package edu.it.ejemplos;

import edu.it.EndOfWineException;

public class JuegoServirCopas {
	public void run() {
		var botella = new BotellaService();
		try {
			botella.servirCopa();
			int z = 0;
			int x = 2 / z;  
			botella.servirCopa();
			botella.servirCopa();
		}
		catch (EndOfWineException ex) {
			System.out.println(ex.descripcion);
			System.out.println(ex.cantidadRestante);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
}
