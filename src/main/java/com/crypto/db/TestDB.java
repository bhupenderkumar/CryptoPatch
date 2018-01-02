package com.crypto.db;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class TestDB {
	public boolean testDBConnection() throws UnknownHostException
	{
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // Now connect to your databases
        @SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "crypto" );
        System.out.println("Connect to database successfully");

        Records t=new Records();
        t.setId(100);
        t.setName("Ghorbani");
        DBCollection collection = null ;
        collection = db.getCollection("test");
        collection.save(t);
        System.err.println(collection.findOne());

        DBCollection school = db.getCollection("college");

        System.out.println("Collection mycol created successfully");
        return true;
	}
	public static void main(String[] args) {
		TestDB t= new TestDB();
//		t.testDBConnection();
		
	}
}