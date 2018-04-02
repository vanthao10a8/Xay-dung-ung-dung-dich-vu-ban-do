package com.connecting.ws.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;



public class Busy extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public Busy(){
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		String cmnd;
		////////////////////////////////// QUERY /////////////////////////////////////
		cmnd = request.getParameter("cmnd");
		////////////////////////////////// ADD /////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
        @SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
        DBCollection services = db.getCollection("Drivers");
        
        DBObject where = new BasicDBObject("cmnd", cmnd);
        
        DBObject update = new BasicDBObject();
        update.put("lat", 0.0);
        update.put("lang", 0.0);
        update.put("jobstt", "Busy");
        
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