package com.mongodb.ws.psswd;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class CPass extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public CPass() {

	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{
		String acc, opw, npw;
		////////////////////////////////////////////////////////////////////////////
		String query = request.getQueryString();
		System.out.println(query);
		String[] splitquery = query.split("&");
		acc = splitquery[0].substring(4,splitquery[0].length());
		opw = splitquery[1].substring(4,splitquery[1].length());
		npw = splitquery[1].substring(4,splitquery[1].length());
		////////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection services = db.getCollection("Drivers");
		////////////////////////////////////////////////////////////////////////////
		BasicDBObject loginQuery = new BasicDBObject();
		List<BasicDBObject> listobj = new ArrayList<BasicDBObject>();
		listobj.add(new BasicDBObject("cmnd", acc));
		listobj.add(new BasicDBObject("pass", opw));
		loginQuery.put("$and", listobj);	
		BasicDBObject cpassQuery = new BasicDBObject();
		cpassQuery.append("$set",new BasicDBObject().append("pass", npw));
		services.update(loginQuery, cpassQuery);		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
