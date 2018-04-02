package com.connecting.ws.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.Collectors;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.ws.mail.SendMail;
import com.mongodb.ws.psswd.Psswd;


public class RegDriver extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public RegDriver(){
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException
	{
		
		request.setCharacterEncoding("UTF8");
		String hoten = "", sdt = "", bienso = "", loaixe = "", cmnd = "", diachi = "", email = "", psswd = "";
		////////////////////////////////// QUERY /////////////////////////////////////
		psswd = Psswd.crePsswd();
		String result = request.getReader().lines().collect(Collectors.joining());
		try {
			JSONObject jsonrequest = new JSONObject(result);
			hoten = (String) jsonrequest.get("hoten");
			sdt = (String) jsonrequest.get("sdt");
			email = (String) jsonrequest.get("email");
			bienso = (String) jsonrequest.get("bienso");
			loaixe = (String) jsonrequest.get("loaixe");
			cmnd = (String) jsonrequest.get("cmnd");
			diachi = (String) jsonrequest.get("diachi");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}	
		System.out.print(hoten+"/"+sdt+"/"+email+"/"+bienso+"/"+loaixe+"/"+cmnd+"/"+diachi);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		////////////////////////////////// ADD /////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection services = db.getCollection("Drivers");
		BasicDBObject document = new BasicDBObject();
		document.put("hoten", hoten);
		document.put("sdt", sdt);
		document.put("email", email);
		document.put("pass", Psswd.hash(psswd));
		document.put("bienso", bienso);
		document.put("loaixe", loaixe);
		document.put("cmnd", cmnd);
		document.put("diachi", diachi);
		document.put("diem", 8.0);
		document.put("danhan", 0);
		document.put("daxong", 0);
		document.put("ngaythamgia", dateFormat.format(cal.getTime()));
		document.put("logstt", "No");
		document.put("jobstt", "No");
		document.put("lat", 0.0);
		document.put("lang", 0.0);
		document.put("gcmid", "");
		/////////////////////////////////////////////////////////
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Done");
		response.getWriter().flush();
		response.getWriter().close();
		/////////////////////////////////////////////////////////
		boolean cmail = SendMail.sendMail(email, hoten, cmnd, psswd);
		if(cmail == true)
		{
			services.insert(document);
			mongo.close();
		}
		else
		{
			mongo.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		request.setCharacterEncoding("UTF8");
		response.setCharacterEncoding("UTF8");
	}
}
