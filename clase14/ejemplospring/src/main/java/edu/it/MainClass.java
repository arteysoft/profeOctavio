package edu.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.it.ejemplos.ConnectionManager;
import edu.it.ejemplos.EjemploCreacionUnUsuarioRandom;

@Component
public class MainClass implements CommandLineRunner {
	
	@Autowired
	private ConnectionManager connectionManager;
	
	@Autowired
	private EjemploCreacionUnUsuarioRandom ejemploCreacionUnUsuarioRandom;
	
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo...");
		
		try {
			connectionManager.conectar();
		}
		catch (edu.it.error.SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		ejemploCreacionUnUsuarioRandom.run();
		
		/*
		 * Crear una clase EmisionFactura con un metodo emitirFactura
		 * Crear una clase calculoIva con un metodoCalcular
		 * 
		 * MainClass depende de EmisionFactura que depende de CalculoIva
		 * MainClass ---------> EmisionFactura -------------> CalculoIva
		 * 
		 */
	}
}
