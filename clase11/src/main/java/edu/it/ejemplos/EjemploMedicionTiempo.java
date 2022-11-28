package edu.it.ejemplos;

import edu.itutiles.Utiles;

public class EjemploMedicionTiempo {
	public void run() {
		Utiles.tomarLapsoTiempo("Tomo el lapso de tiempo en el main", () -> {
			// new EjemploMedicionTiempo().run();
			for (Integer i = 0; i < 100000; i++) {
				for (Integer i1 = 0; i1 < 10000; i1++) {}
			}
		});
	}
	
}
