package edu.it.ejemplos;

import com.google.gson.Gson;

import edu.itutiles.Utiles;

public class EjemploCreacionUnUsuarioRandom {
	public void run() {
		var usuario = Utiles.crearUsuarioRandom();
		var usuJson = new Gson().toJson(usuario);
		System.out.println(usuJson);
	}
}
