package edu.it.colecciones;

import java.util.ArrayList;

public class Sintaxis {
	public void run() {
		var lista = new ArrayList<String>();
		
		lista.add("Hola que tal");
		lista.add("como estas ?");
		lista.add("Asi continua");
		
		for (String s : lista) {
			System.out.println(s);
		}
		
		lista.remove(0);
		
		for (String s : lista) {
			System.out.println(s);
		}
		
		lista.remove(0);
		
		for (String s : lista) {
			System.out.println(s);
		}
		
		lista.remove(0);
		lista.remove(0);
	}
}
