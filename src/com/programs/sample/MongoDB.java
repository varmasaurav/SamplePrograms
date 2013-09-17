package com.programs.sample;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

//Java - MongoDB Direct Connection for localhost
public class MongoDB {
	
	public static void main(String arg[]){
		try {
			MongoClient local = new MongoClient("localhost");
			DB db = local.getDB("referall");
			DBCollection coll = db.getCollection("referall");
			coll.setWriteConcern(WriteConcern.JOURNALED);
			BasicDBObject doc = new BasicDBObject("name","Saurav Varma").
									append("company", "CSC");
			
			coll.insert(doc);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
