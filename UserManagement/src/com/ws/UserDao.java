package com.ws;  

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;

import com.entity.CoffeeShop;
import com.entity.MarkerInfo;
import com.google.gson.Gson;
import com.model.CRUD;
import com.model.DbUltis;  

public class UserDao { 
	BufferedWriter bw = null;
	FileWriter fw = null;
	public static String FILENAME = "D:\\appCfMap\\DataOutPut\\map.html";

	public String requestMapbyLocation(String lat, String lng){ 
		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"  <head>\r\n" + 
					"    <style>\r\n" + 
					"       #map {\r\n" + 
					"        height: 400px;\r\n" + 
					"        width: 100%;\r\n" + 
					"       }\r\n" + 
					"    </style>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <h3>My Google Maps Demo</h3>\r\n" + 
					"    <div id=\"map\"></div>\r\n" + 
					"    <script>\r\n" + 
					"      function initMap() {");
			bw.newLine();
			bw.write("var uluru = {lat: " + lat + ",lng: " + lng+"};");
			bw.newLine();
			bw.write("var map = new google.maps.Map(document.getElementById('map'), {\r\n" + 
					"          zoom: 20,\r\n" + 
					"          center: uluru\r\n" + 
					"        });\r\n" + 
					"        var marker = new google.maps.Marker({\r\n" + 
					"          position: uluru,\r\n" + 
					"          map: map\r\n" + 
					"        });\r\n" + 
					"      }\r\n" + 
					"    </script>\r\n" + 
					"    <script async defer\r\n" + 
					"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBMk0hyikASljEIbOKTWjBf_IUoyO3WrDM&callback=initMap\">\r\n" + 
					"    </script>\r\n" + 
					"  </body>\r\n" + 
					"</html>");
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "done"; 
	}
	public String requestMapbyLocationString(String lat, String lng){ 
		String s = "(<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"  <head>\r\n" + 
				"    <style>\r\n" + 
				"       #map {\r\n" + 
				"        height: 900px;\r\n" + 
				"        width: 100%;\r\n" + 
				"       }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <h3>My Google Maps Demo</h3>\r\n" + 
				"    <div id=\"map\"></div>\r\n" + 
				"    <script>\r\n" + 
				"      function initMap() {)" + 
				"var uluru = {lat: " + lat + ",lng: " + lng+"};)"+"var map = new google.maps.Map(document.getElementById('map'), {\r\n" + 
				"          zoom: 20,\r\n" + 
				"          center: uluru\r\n" + 
				"        });\r\n" + 
				"        var marker = new google.maps.Marker({\r\n" + 
				"          position: uluru,\r\n" + 
				"          map: map\r\n" + 
				"        });\r\n" + 
				"      }\r\n" + 
				"    </script>\r\n" + 
				"    <script async defer\r\n" + 
				"    src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBMk0hyikASljEIbOKTWjBf_IUoyO3WrDM&callback=initMap\">\r\n" + 
				"    </script>\r\n" + 
				"  </body>\r\n" + 
				"</html>)";
		System.out.println("Done");

		return s; 
	}

	public ArrayList<String> pushFromDB() {
		CRUD crd = new CRUD();
		ArrayList<CoffeeShop> cf = new ArrayList<>();
		cf = crd.getAllDocument();
		ArrayList<String> arr = new ArrayList<>();
		for (CoffeeShop coffeeShop : cf) {
			String info = "";
			info += coffeeShop.getName();
			info += ":";
			info += coffeeShop.getAddress();
			//String[] cfin = {coffeeShop.getLat(),coffeeShop.getLng(),info}; 
			double x = Double.parseDouble(coffeeShop.getLat());
			double y = Double.parseDouble(coffeeShop.getLng());
			MarkerInfo mki = new MarkerInfo(x,y,info);
			Gson gson = new Gson();
			//System.out.println(mki.toString());
			arr.add(gson.toJson(mki));
		}
		//System.out.println(arr);
		return arr;
	}
}

/*private void saveUserList(List<User> userList){ 
      try { 
         File file = new File("Users.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    */
