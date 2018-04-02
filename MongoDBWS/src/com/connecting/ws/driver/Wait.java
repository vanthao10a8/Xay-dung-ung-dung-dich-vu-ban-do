package com.connecting.ws.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;



public class Wait extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Wait(){
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		double lat = 0.0, lang = 0.0;
		String cmnd = "";
		////////////////////////////////// QUERY /////////////////////////////////////
		String result = request.getReader().lines().collect(Collectors.joining());
		try {
			JSONObject jsonrequest = new JSONObject(result);
			cmnd = (String) jsonrequest.get("cmnd");
			lat = (Double) jsonrequest.get("lat");
			lang = (Double) jsonrequest.get("lang");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	
		////////////////////////////////// ADD /////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
        @SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
        DBCollection services = db.getCollection("Drivers");
        
        DBObject where = new BasicDBObject();
        List<BasicDBObject> listwhere = new ArrayList<BasicDBObject>();
        listwhere.add(new BasicDBObject("cmnd", cmnd));
        listwhere.add(new BasicDBObject("logstt", "Yes"));
		where.put("$and", listwhere);
         
        DBObject update = new BasicDBObject();
        update.put("lat", lat);
        update.put("lang", lang);
        update.put("jobstt", "Wait");
        
        DBObject valuesWithSet = new BasicDBObject();
        valuesWithSet.put("$set", update);
           
		services.update(where, valuesWithSet);
		mongo.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
