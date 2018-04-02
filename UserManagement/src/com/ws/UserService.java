package com.ws;  

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/UserService") 

public class UserService {  
   UserDao userDao = new UserDao();  
   @GET 
   @Path("/getMap") 
   @Produces(MediaType.APPLICATION_JSON) 
   public String getMaps(){ 
      return userDao.requestMapbyLocation("10.834947", "106.667180"); 
   }  
   @GET
   @Path("/getMapString") 
   @Produces(MediaType.APPLICATION_JSON) 
   public String getMapString(){ 
      return userDao.requestMapbyLocationString("10.847178","106.791296"); 
   }  
   @GET 
   @Path("/pushFromDB") 
   @Produces(MediaType.APPLICATION_JSON) 
   public Response pushFromDB(){ 
      return  Response.ok(userDao.pushFromDB())
		      .header("Access-Control-Allow-Origin", "*")
		      .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
		      .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
   } 

}