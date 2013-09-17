package com.programs.sample;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoURI;
import com.mongodb.WriteConcern;

//Java - MongoDB Direct Connection for localhost
public class MongoDBExternal {
	
	public static void main(String arg[]){
		try {
			MongoURI uri = new MongoURI("mongodb://savarma:referall@paulo.mongohq.com:10020/referall");
			//MongoClient local = new MongoClient("localhost");
			Mongo local = uri.connect();
			DB db = local.getDB("referall");
			//String db_name = uri.getDatabase();
			DBCollection coll = db.getCollection("referall");
			coll.setWriteConcern(WriteConcern.JOURNALED);
			BasicDBObject doc = new BasicDBObject("name","Madhu Varma").
									append("company", "TCS");
			
			coll.insert(doc);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
