package com.connecting.ws.custommer;

import java.io.IOException;
import java.net.UnknownHostException;

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

public class DeniedDriver extends HttpServlet {

	private JSONArray ListReceiver;
	private JSONObject SenderInfo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeniedDriver(){
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{
		String idcus = "";
		idcus = request.getParameter("idcus");
		///////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection drvservices = db.getCollection("Drivers");
		BasicDBObject drvQuery = new BasicDBObject("jobstt", "W"+idcus);
		DBObject updatestt = new BasicDBObject("jobstt", "Wait");
		DBCursor cursordrv = drvservices.find(drvQuery);
		ListReceiver =new JSONArray();
		try 
		{
			while (cursordrv.hasNext()) 
			{
				DBObject doc = cursordrv.next();
				JSONObject obj = new JSONObject();
				String gcmdrv = (String) doc.get("gcmid");
				try {
					obj.put("gcmrcv", gcmdrv);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				ListReceiver.put(obj);
			}
		}finally {
			cursordrv.close();
		}
		DBObject valuesWithSet = new BasicDBObject();
        valuesWithSet.put("$set", updatestt);
		drvservices.update(drvQuery, valuesWithSet);
		mongo.close();
		try {
			SenderInfo = new JSONObject();
			SenderInfo.put("Failer", "Transactions Denied");
			PushGCM.sendGCM(ListReceiver, SenderInfo);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
