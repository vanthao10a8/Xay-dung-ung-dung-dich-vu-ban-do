package com.connecting.ws.driver;

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

public class RecvTrans extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private JSONObject SenderInfo;
	private JSONArray ListReceiver;
	public RecvTrans(){
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		String iddriver = "", gcmcus = "", idcus = "";
		////////////////////////////////// QUERY /////////////////////////////////////
		iddriver = request.getParameter("iddriver");
		gcmcus = request.getParameter("gcmcus");
		idcus = request.getParameter("idcus");
		try {
			ListReceiver = new JSONArray();
			JSONObject obj = new JSONObject();
			obj.put("gcmrcv", gcmcus);
			ListReceiver.put(obj);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		////////////////////////////////// Connect  /////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		///////////////////////////////// Check /////////////////////////////////////////
		DBCollection cusservices = db.getCollection("Custommers");
		BasicDBObject cusQuery = new BasicDBObject();
		List<BasicDBObject> cuslistobj = new ArrayList<BasicDBObject>();
		cuslistobj.add(new BasicDBObject("sdt", idcus));
		cuslistobj.add(new BasicDBObject("jobstt", "Wait"));
		cusQuery.put("$and", cuslistobj);
		DBCursor cuscursor = cusservices.find(cusQuery);
		Boolean check = false;
		try 
		{
			while (cuscursor.hasNext()) 
			{
				check = true;
				break;
			}
		} finally {
			cuscursor.close();
		}
		////////////////////////////////////////////////////////////////////////////////
		if(check == true)
		{
			DBCollection services = db.getCollection("Drivers");
			BasicDBObject Query = new BasicDBObject("cmnd", iddriver);
			DBCursor cursor = services.find(Query);
			try 
			{
				while (cursor.hasNext()) 
				{
					DBObject doc  = cursor.next();
					try {
						SenderInfo = new JSONObject();
						SenderInfo.put("hoten", (String) doc.get("hoten"));
						SenderInfo.put("sdt", (String) doc.get("sdt"));
						SenderInfo.put("bienso", (String) doc.get("bienso"));
						SenderInfo.put("loaixe", (String) doc.get("loaixe"));
						SenderInfo.put("cmnd", (String) doc.get("cmnd"));
						SenderInfo.put("diem", (Double) doc.get("diem"));
						SenderInfo.put("lat", (Double) doc.get("lat"));
						SenderInfo.put("lang", (Double) doc.get("lang"));
						SenderInfo.put("gcmid", (String) doc.get("gcmid"));
						break;
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} finally {
				cursor.close();
			} 
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Đã Gửi Thành Công");
			response.getWriter().flush();
			response.getWriter().close();
			try {
				PushGCM.sendGCM(ListReceiver, SenderInfo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			DBObject where = new BasicDBObject("cmnd", iddriver);
			DBObject update = new BasicDBObject();
			update.put("jobstt", "W"+idcus);
			DBObject valuesWithSet = new BasicDBObject();
			valuesWithSet.put("$set", update);
			DBCollection drvservices = db.getCollection("Drivers");
			drvservices.update(where, valuesWithSet);
			mongo.close();
		}
		else
		{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Đã Gửi Thất Bại");
			response.getWriter().flush();
			response.getWriter().close();
			mongo.close();
		}

	}
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
