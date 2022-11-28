package edu.itutiles;

import java.util.Random;
import java.util.UUID;

import com.github.javafaker.Faker;

import edu.it.dto.Usuario;

public class Utiles {
	private static Faker fkr;
	
	static {
		fkr = new Faker();
	}
	public static void tomarLapsoTiempo(String titulo, Runnable r) {
		System.out.println("Tomando tiempo de: " + titulo);
		long antes = System.currentTimeMillis();
		// late binding, es lo mismo que decir, no sabe contra que referencia se expone.
		r.run();
		long despues = System.currentTimeMillis();
		long diferencia = despues - antes;
		System.out.println();
		System.out.println("Esto tarda.. " + String.valueOf(diferencia) + " ms");
	}
	public static Usuario crearUsuarioRandom() {
		Usuario usu = new Usuario();
        usu.id = UUID.randomUUID().toString();
        usu.nombre = fkr.address().firstName();
        usu.apellido = fkr.address().lastName();
        usu.domicilio = fkr.address().streetName() + " " + fkr.address().streetAddressNumber();
        usu.pais = fkr.address().country();
        usu.saldoCuenta = new Random().nextInt(1000000);
        
        return usu;
	}
	public static void intentarOperacion(RunnableConException r) {
		// Intenta realizar una operacion, pero si falla, traga el exception
		try {
			r.run();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
