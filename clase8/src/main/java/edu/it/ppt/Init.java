package edu.it.ppt;

import edu.it.ppt.service.Juego;
import edu.it.ppt.service.PPTReaderConsola;
import edu.it.ppt.service.PPTReaderRandom;

public class Init {
	public void run() {
		var res = new Juego(new PPTReaderConsola(), new PPTReaderRandom()).jugar();
		if (res == 0) {
			System.out.println("Empate !!!");
		}
		System.out.println("El ganador es: " + res);
	}
}
