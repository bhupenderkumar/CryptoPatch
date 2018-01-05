package com.crypto.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.servlet.ServletException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoConnection implements IMongoConnection {

	public boolean testConnection() {
		// TODO Auto-generated method stub
//		MongoClient mongoClient = new MongoClient();
//		DB db = mongoClient.getDB("crypto");
//		DBCollection school = db.getCollection("college");
//		System.out.println("Collection mycol created successfully");
		return true;
	}  

	public static void main(String[] args) throws UnknownHostException, ServletException {
		Mongo mongo;
		DB mongoDB;
		String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
		String sport = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
		String db = System.getenv("OPENSHIFT_APP_NAME");
		if (db == null)
			db = "mydb";
		String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
		String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
		int port = Integer.decode(sport);

		try {
			mongo = new Mongo(host, port);
		} catch (UnknownHostException e) {
			throw new ServletException("Failed to access Mongo server", e);
		}
		mongoDB = mongo.getDB(db);
		if (mongoDB.authenticate(user, password.toCharArray()) == false) {
			throw new ServletException("Failed to authenticate against db: " + db);
		}
	}

	public static String storeInDB(String fsym,String tsyms) {
//		String fsym ="XRP";
//		String tsyms ="BTC,USD,INR";
		try {
			URL url = new URL(coinMarketUrl+"?fsym="+fsym+"&tsyms="+tsyms);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuilder builder = new StringBuilder();
			while ((output = br.readLine()) != null) {
				builder.append(output);
			}
			conn.disconnect();
			return builder.toString();
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return "";
	}

}
