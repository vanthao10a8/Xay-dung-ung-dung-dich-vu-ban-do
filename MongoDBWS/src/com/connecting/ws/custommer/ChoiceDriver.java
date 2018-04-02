package com.connecting.ws.custommer;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.connecting.ws.gcm.PushGCM;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class ChoiceDriver extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private JSONObject SenderInfo;
	private JSONArray ListReceiver;
	
	public ChoiceDriver(){
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		String iddrv = "", gcmdrv = "", idcus = "";
		////////////////////////////////// QUERY /////////////////////////////////////
		iddrv = request.getParameter("iddriver");
		gcmdrv = request.getParameter("gcmdrv");
		idcus = request.getParameter("idcus");
		System.out.print(idcus);
		try {
			ListReceiver = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("gcmrcv", gcmdrv);
			ListReceiver.put(obj);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		/////////////////////////////////// Check ///////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection drvservices = db.getCollection("Drivers");
		BasicDBObject drvQuery = new BasicDBObject();
		List<BasicDBObject> drvlistobj = new ArrayList<BasicDBObject>();
		drvlistobj.add(new BasicDBObject("cmnd", iddrv));
		drvlistobj.add(new BasicDBObject("jobstt", "W"+idcus));
		drvQuery.put("$and", drvlistobj);
		DBCursor drvcursor = drvservices.find(drvQuery);
		Boolean check = false;
		try 
		{
			while (drvcursor.hasNext()) 
			{
				check = true;
				DBObject updatestt = new BasicDBObject("jobstt", idcus);
				DBObject valuesWithSet = new BasicDBObject("$set", updatestt);
				drvservices.update(drvQuery, valuesWithSet);
				break;
			}
		} finally {
			drvcursor.close();
		}
		DBCollection cusservices = db.getCollection("Custommers");
		DBObject cusQuery = new BasicDBObject("sdt", idcus);
		DBObject cusupdate = new BasicDBObject("driver", iddrv);
		DBObject cusSet = new BasicDBObject("$set", cusupdate);
		cusservices.update(cusQuery, cusSet);
		////////////////////////////////// Connect  /////////////////////////////////////
		if(check == true)
		{			
			DBCollection services = db.getCollection("Transactions");
			DBObject where = new BasicDBObject();
			where.put("idcus", idcus);
			DBObject update = new BasicDBObject();
			update.put("iddrv", iddrv);
			DBObject valuesWithSet = new BasicDBObject();
	        valuesWithSet.put("$set", update);
	        services.update(where, valuesWithSet);
	        response.getWriter().write("Success");
			response.getWriter().flush();
			response.getWriter().close();
			mongo.close();
			try {
				
				SenderInfo = new JSONObject();
				SenderInfo.put("Success", "Transactions Accepted");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			try {
				PushGCM.sendGCM(ListReceiver, SenderInfo);
			} catch (JSONException e) {
				e.printStackTrace();
			}	
		}
		else
		{
			mongo.close();
	        response.getWriter().write("Fail");
			response.getWriter().flush();
			response.getWriter().close();
		}		
	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}