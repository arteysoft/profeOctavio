package edu.it.ejemplos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import edu.itutiles.Utiles;

@Component
public class EjemploCreacionUnUsuarioRandom {
	@Autowired
	SerializadorJSON serializadorJson; 
	
	public void run() {
		var usuario = Utiles.crearUsuarioRandom();
		var usuJson = serializadorJson.serializar(usuario);
		System.out.println(usuJson);
	}
}
