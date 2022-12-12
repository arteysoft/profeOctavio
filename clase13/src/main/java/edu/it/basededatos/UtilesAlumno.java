package edu.it.basededatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.github.javafaker.Faker;

import edu.it.entities.Alumno;

public class UtilesAlumno {
	private static Faker fkr;
	
	static {
		fkr = new Faker();
	}
	
	public static Alumno generarAlumnoRandom() {	
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
	public static Alumno mapperRsAlumno(ResultSet rs) throws SQLException {
		var ret = new Alumno(
				rs.getString("id"),
				rs.getString("nombre"),
				rs.getString("apellido"),
				rs.getString("calle"),
				rs.getString("calleNumero"),
				rs.getString("estado"),
				rs.getString("pais")
	        );
		
		return ret;
	}
}
