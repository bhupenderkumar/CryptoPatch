package com.crypto.ws;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crypto.apiClasses.CoinMarketCap;
import com.crypto.component.IPersonService;
import com.crypto.ws.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.Mongo;

@RestController
@RequestMapping("/data")
public class CryptoController {
	@Autowired
	private IPersonService personService;

	@RequestMapping("/person")
	public Person getPersonDetail(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
		Person p = personService.getPersonDetail(id);
		return p;
	}
	@RequestMapping("/getCoinMarketPrice")
	public CoinMarketCap[] getPersonDetail() throws JsonParseException, JsonMappingException, IOException, ServletException {
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
			System.out.println("Connection succesfull");
			
		} catch (UnknownHostException e) {
			throw new ServletException("Failed to access Mongo server", e);
		}
		mongoDB = mongo.getDB(db);
		if (mongoDB.authenticate(user, password.toCharArray()) == false) {
			throw new ServletException("Failed to authenticate against db: " + db);
		}
		CoinMarketCap coinMarketCap = new CoinMarketCap();
		String str=coinMarketCap.getCoinMarketCap();
		ObjectMapper mapper = new ObjectMapper();
		CoinMarketCap[] CoinMarketCaparr = mapper.readValue(str, CoinMarketCap[].class); 
		return CoinMarketCaparr;
	}
}