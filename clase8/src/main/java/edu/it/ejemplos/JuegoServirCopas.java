package edu.it.ejemplos;

import edu.it.EndOfWineException;

public class JuegoServirCopas {
	public void run() {
		var botella = new BotellaService();
		try {
			botella.servirCopa();
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
		finally {
			System.out.println("Pasa siempre por aca... cierra conexiones, etc.");
		}
	}
}
