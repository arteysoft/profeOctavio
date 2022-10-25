package edu.it.ppt;

import java.util.HashMap;

import edu.it.ppt.service.Juego;
import edu.it.ppt.service.PPTReaderConsola;
import edu.it.ppt.service.PPTReaderRandom;

public class Init {
	public void run() {
		HashMap<Integer, String> mapaResultado = new HashMap<>();
		
		mapaResultado.put(0, "Empate");
		mapaResultado.put(1, "Gano Yooooooooo");
		mapaResultado.put(2, "Me gano la maquina");
		
		var res = new Juego(new PPTReaderConsola(), new PPTReaderRandom()).jugar();
		if (res == 0) {
			System.out.println("Empate !!!");
		}
		System.out.println("El resultado es: " + mapaResultado.get(res));
	}
}
