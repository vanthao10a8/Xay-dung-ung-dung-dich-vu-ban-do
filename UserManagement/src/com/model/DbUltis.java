package com.model;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbUltis {
	private final static String HOST = "localhost";
	private final static int PORT = 27017;
	private MongoCollection<Document> coll = null;
	private MongoClient mongoClient;
	
	public DbUltis() {
		setColl(getConnect());
	}
	
	public MongoCollection<Document> getColl() {
		return coll;
	}

	public void setColl(MongoCollection<Document> coll) {
		this.coll = coll;
	}

	private synchronized MongoCollection<Document> getConnect() {
		mongoClient = new MongoClient(HOST, PORT);
		MongoDatabase db = mongoClient.getDatabase("MapManagerDB");
		MongoCollection<Document> coll = db.getCollection("CoffeeShopData");
		return coll;
	}
	
	public void closeConnect() {
		if(mongoClient!=null)
			mongoClient.close();
	}
	
}
