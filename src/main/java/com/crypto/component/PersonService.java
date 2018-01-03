package com.crypto.component;
import org.springframework.stereotype.Component;

import com.crypto.ws.Person;
@Component
public class PersonService implements IPersonService {
	@Override
	public Person getPersonDetail(Integer id){
		Person p = new Person();
		p.setId(id);
		p.setLocation("Varanasi");
		p.setName("Ram");
		return p;
	}
} 