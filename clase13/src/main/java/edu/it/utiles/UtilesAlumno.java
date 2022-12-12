package edu.it.utiles;

import java.util.UUID;

import com.github.javafaker.Faker;

import edu.it.entities.Alumno;

public class UtilesAlumno {
	public static Alumno generarAlumnoRandom() {
		Faker fkr = new Faker();
		
		return new Alumno(
				UUID.randomUUID().toString(),
	            fkr.address().firstName(),
	            fkr.address().lastName(),
	            fkr.address().streetName(),
	            fkr.address().streetAddressNumber(),
	            fkr.address().state(),
	            fkr.address().country()
	        );
	}
}
