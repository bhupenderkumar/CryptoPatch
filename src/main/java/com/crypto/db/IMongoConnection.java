package com.crypto.db;

public interface IMongoConnection {
//	 Username: user3HW
//     Password: fwUPgXKrVi23aH5o
//Database Name: sampledb
//Connection URL: 
	
	String username="user3HW";
	String password="fwUPgXKrVi23aH5o";
	String url ="mongodb://user3HW:fwUPgXKrVi23aH5o@mongodb/sampledb";
	int port=27017;
	String coinMarketUrl="https://min-api.cryptocompare.com/data/price";
	
	public boolean testConnection();
}
