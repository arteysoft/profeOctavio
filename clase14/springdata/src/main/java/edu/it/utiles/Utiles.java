package edu.it.utiles;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import edu.it.dto.Usuario;

@Component
public class Utiles {
	private Faker fkr;
	
	public Utiles() {
		fkr = new Faker();
	}
	public Usuario crearUsuarioRandom() {
		Usuario usu = new Usuario();
        usu.id = UUID.randomUUID().toString();
        usu.nombre = fkr.address().firstName();
        usu.apellido = fkr.address().lastName();
        usu.domicilio = fkr.address().streetName() + " " + fkr.address().streetAddressNumber();
        usu.pais = fkr.address().country();
        usu.saldoCuenta = new Random().nextInt(1000000);
        
        return usu;
	}
}
