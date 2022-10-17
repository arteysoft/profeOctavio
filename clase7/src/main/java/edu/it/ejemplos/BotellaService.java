package edu.it.ejemplos;

import edu.it.EndOfWineException;

public class BotellaService {
	private Integer cm3Restantes = 1000;
	private Integer CANTIDAD_POR_COPA = 350;
	
	public void servirCopa() {
		if (cm3Restantes - CANTIDAD_POR_COPA < 0) {
			throw new EndOfWineException("No se puede realizar la operacion, quedan", cm3Restantes);
		}
		cm3Restantes -= CANTIDAD_POR_COPA;
	}
}
