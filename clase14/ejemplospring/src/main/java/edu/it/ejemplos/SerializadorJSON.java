package edu.it.ejemplos;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class SerializadorJSON {
	Gson gson = new Gson();
	
	public String serializar(Object objeto) {
		return gson.toJson(objeto);
	}
}
