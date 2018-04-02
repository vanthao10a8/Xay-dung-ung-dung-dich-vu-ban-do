package com.connecting.ws.driver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public Login() {

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, UnknownHostException{
		String acc, pwd;
		String hoten, sdt, bienso, loaixe, cmnd, diachi, email;
		Double diem;
		boolean logsuccess = false;
		JSONObject obj = new JSONObject();
		////////////////////////////////////////////////////////////////////////////
		String query = request.getQueryString();
		System.out.println(query);
		String[] splitquery = query.split("&");
		acc = splitquery[0].substring(4,splitquery[0].length());
		pwd = splitquery[1].substring(4,splitquery[1].length());
		////////////////////////////////////////////////////////////////////////////
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo("localhost", 27017); 
		@SuppressWarnings("deprecation")
		DB db = mongo.getDB("LocalMongoDb");
		DBCollection services = db.getCollection("Drivers");
		////////////////////////////////////////////////////////////////////////////
		BasicDBObject andQuery = new BasicDBObject();
		List<BasicDBObject> listobj = new ArrayList<BasicDBObject>();
		listobj.add(new BasicDBObject("cmnd", acc));
		listobj.add(new BasicDBObject("pass", pwd));
		andQuery.put("$and", listobj);
		///////////////////////////////////////////////////////////////////////////
		DBCursor cursor = services.find(andQuery);
		try 
		{
			while (cursor.hasNext()) 
			{
				DBObject doc = cursor.next();
				hoten = (String) doc.get("hoten");
				sdt = (String) doc.get("sdt");
				email = (String) doc.get("email");
				bienso = (String) doc.get("bienso");
				loaixe = (String) doc.get("loaixe");
				cmnd = (String) doc.get("cmnd");
				diachi = (String) doc.get("diachi");
				diem = (Double) doc.get("diem");
				try {
					obj.put("hoten", hoten);
					obj.put("sdt", sdt);
					obj.put("email", email);
					obj.put("bienso", bienso);
					obj.put("loaixe", loaixe);
					obj.put("cmnd", cmnd);
					obj.put("diachi", diachi);
					obj.put("diem", diem);
					logsuccess = true;
				} catch (JSONException e) {
					logsuccess = false;
				}
			}
		} finally {
			cursor.close();
		}
		if(logsuccess == true)
		{
			DBObject where = new BasicDBObject();
			where.put("cmnd", acc);
			DBObject update = new BasicDBObject();
			update.put("logstt", "Yes");
			DBObject valuesWithSet = new BasicDBObject();
	        valuesWithSet.put("$set", update);
	        services.update(where, valuesWithSet);
			
			//And write the string to output.
			final String output = obj.toString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(output);
			response.getWriter().flush();
			response.getWriter().close();
		}
		else
		{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
			response.getWriter().flush();
			response.getWriter().close();
		}
		mongo.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}