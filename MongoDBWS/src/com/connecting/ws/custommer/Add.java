package com.connecting.ws.custommer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.connecting.ws.gcm.PushGCM;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONObject SenderInfo;
	private JSONArray ListReceiver;
	private double lat = 0.0;
	private double lang = 0.0;
	private String sdt = "";
	private String noiden = "";
	private String noidi = "";
	public Add() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		int countMess = 0;
		String gcmdrv;
		double x,y;	
		//////////////////////////////////QUERY /////////////////////////////////////
		String result = request.getReader().lines().collect(Collectors.joining());

		try {
			SenderInfo = new JSONObject(result);
			sdt = (String) SenderInfo.get("sdt");
			noidi = (String) SenderInfo.get("noidi");
			noiden = (String) SenderInfo.get("noiden");
			lat = (Double) SenderInfo.get("lat");
			lang = (Double) SenderInfo.get("lang");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	
		///////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongocus = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB dbcus = mongocus.getDB("LocalMongoDb");
		DBCollection servicescus = dbcus.getCollection("Custommers");
		
		DBObject where = new BasicDBObject();
        List<BasicDBObject> listwhere = new ArrayList<BasicDBObject>();
        listwhere.add(new BasicDBObject("sdt", sdt));
        listwhere.add(new BasicDBObject("logstt", "Yes"));
		where.put("$and", listwhere);
         
        DBObject update = new BasicDBObject();
        update.put("from", noidi);
        update.put("to", noiden);
        update.put("jobstt", "Wait");
        
        DBObject valuesWithSet = new BasicDBObject();
        valuesWithSet.put("$set", update);
           
        servicescus.update(where, valuesWithSet);
        mongocus.close();
		/////////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongodrv = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB dbdrv = mongodrv.getDB("LocalMongoDb");
		DBCollection servicesdrv = dbdrv.getCollection("Drivers");
		DBObject drvwhere = new BasicDBObject();
		List<BasicDBObject> drvlistwhere = new ArrayList<BasicDBObject>();
		drvlistwhere.add(new BasicDBObject("logstt", "Yes"));
		drvlistwhere.add(new BasicDBObject("jobstt", "Wait"));
		drvwhere.put("$and", drvlistwhere);
		DBCursor cursordrv = servicesdrv.find(drvwhere);
		///////////////////////////////////////////////////////////////////////////
		ListReceiver =new JSONArray();
		try 
		{
			while (cursordrv.hasNext()) 
			{
				DBObject doc = cursordrv.next();
				JSONObject obj = new JSONObject();
				x = (Double) doc.get("lat");
				y = (Double) doc.get("lang");
				gcmdrv = (String) doc.get("gcmid");
				if((countDis(x,y)<=1.0))
				{
					try {
						countMess++;
						obj.put("gcmrcv", gcmdrv);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					ListReceiver.put(obj);
				}
			}
			DBCollection transcol = dbdrv.getCollection("Transactions");
			BasicDBObject document = new BasicDBObject();
			document.put("idcus", sdt);
			document.put("iddrv", "");
			document.put("noidi", noidi);
			document.put("noiden", noiden);
			document.put("status", "Wait");
			document.put("cusfinished", "No");
			document.put("drvfinished", "No");
			transcol.insert(document);
		} finally {
			cursordrv.close();
		}
		mongodrv.close();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(""+countMess);
		response.getWriter().flush();
		response.getWriter().close();
		if(countMess>0)
		{
			try {
				PushGCM.sendGCM(ListReceiver, SenderInfo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		////////////////////////////////////////////////////////////////////
	}
	public double countDis(Double x, Double y){
		int Radius=6371;
		double dLat = Math.toRadians(lat-x);
		double dLon = Math.toRadians(lang-y);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(x)) * Math.cos(Math.toRadians(lat)) *
				Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return Radius * c;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
