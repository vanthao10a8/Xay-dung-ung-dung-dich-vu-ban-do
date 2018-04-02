package com.mongodb.ws;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.QueryBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String curdate = null;
	public Find() {
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{

		String name, address, time, date ;
		double x,y,lat,lang,dis;
		final JSONArray arr=new JSONArray();
	
		////////////////////////////////////////////////////////////////////////////
		String query = request.getQueryString();
		System.out.println(query);
		String[] splitquery = query.split("&");
		dis = Double.parseDouble(splitquery[0].substring(4,splitquery[0].length()));
		lat = Double.parseDouble(splitquery[1].substring(4,splitquery[1].length()));
		lang = Double.parseDouble(splitquery[2].substring(5,splitquery[2].length()));
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		curdate = dateFormat.format(cal.getTime());
		/////////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection services = db.getCollection("Services");
		////////////////////////////////////////////////////////////////////////////
		DBObject querydt =  QueryBuilder.start("flag").greaterThanEquals("0000")
        		.and(QueryBuilder.start("time").greaterThanEquals(timeFormat.format(cal.getTime())).get())
        		.get();
		///////////////////////////////////////////////////////////////////////////
		DBCursor cursor = services.find(querydt);
		try 
		{
			while (cursor.hasNext()) 
			{
				DBObject doc = cursor.next();
				JSONObject obj = new JSONObject();
				x = (Double) doc.get("x");
				y = (Double) doc.get("y");
				name = "";
				address = "";
				time = (String) doc.get("time");
				date = (String) doc.get("date");
				if((countDis(x,y,lat,lang)<=dis) && checkdate(date))
				{
					try {
						obj.put("x", x);
						obj.put("y", y);
						obj.put("name", name);
						obj.put("address", address);
						obj.put("time", time);
						obj.put("date", date);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					arr.put(obj);
				}
			}
		} finally {
			cursor.close();
		}
		mongo.close();
		final String output = arr.toString();
		//And write the string to output.
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(output);
		response.getWriter().flush();
		response.getWriter().close();


	}
	public double countDis(Double x, Double y, Double lat, Double lang){
		int Radius=6371;
		double dLat = Math.toRadians(lat-x);
		double dLon = Math.toRadians(lang-y);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(x)) * Math.cos(Math.toRadians(lat)) *
				Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return Radius * c;
	}
	public boolean checkdate (String cusdate){
		int cusday, cusmonth, cusyear, curday, curmonth, curyear;
		String[] splitquery = cusdate.split("/");
		String[] splitquery2 = curdate.split("/");
		cusday = Integer.parseInt(splitquery[0].substring(0,splitquery[0].length()));
		cusmonth = Integer.parseInt(splitquery[1].substring(0,splitquery[1].length()));
		cusyear = Integer.parseInt(splitquery[2].substring(0,splitquery[2].length()));
		curday = Integer.parseInt(splitquery2[0].substring(0,splitquery2[0].length()));
		curmonth = Integer.parseInt(splitquery2[1].substring(0,splitquery2[1].length()));
		curyear = Integer.parseInt(splitquery2[2].substring(0,splitquery2[2].length()));
		if(cusyear > curyear)
			return true;
		if(cusyear == curyear && cusmonth > curmonth)
			return true;
		if(cusyear == curyear && cusmonth == curmonth && cusday >= curday)
			return true;
		return false;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
