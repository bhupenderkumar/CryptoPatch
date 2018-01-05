package com.crypto.db;

import java.net.UnknownHostException;

import javax.servlet.ServletException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class TestDB {
	public boolean testDBConnection() throws UnknownHostException, ServletException {
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
		return true;
	}

	public static void main(String[] args) throws UnknownHostException, ServletException {
		TestDB t = new TestDB();
		 t.testDBConnection();

	}
}