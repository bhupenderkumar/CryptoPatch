package com.crypto.db;

import java.io.IOException;

import javax.servlet.ServletException;

import com.crypto.apiClasses.CoinMarketCap;
import com.crypto.ws.CryptoController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class CryptoCurd {

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, ServletException {
		CryptoController controller = new CryptoController();
		CoinMarketCap[] coinMarketCaps = controller.getPersonDetail();
		for(CoinMarketCap cap :coinMarketCaps) {
			System.out.println(cap.getId() +"  " +cap.getSymbol());
		}
	}
	
	
	
}
