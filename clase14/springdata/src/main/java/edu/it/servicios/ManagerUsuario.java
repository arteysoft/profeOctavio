package edu.it.servicios;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class ManagerUsuario {
	private String nombre;
	private String passwordEncriptada;
	private String salt;
	
	public void crearUnUsuario(String nombre, String password) {
		/*
		 * Tres metodos de encriptacion
		 * 
		 * Symetrico ->  A (clave|ALG) ------------------- (clave|ALG) B
		 * Asimetrica -> A (clave|ALG) ------------------- (clave'|ALG) B
		 * Hash -> Input lo paso por una funcion --------- (256 Bits)
		 */
		
		this.nombre = nombre;
		this.salt = String.join("__", UUID.randomUUID().toString(), UUID.randomUUID().toString());		
		var passPorEncriptar = String.join("__", password, salt); 
		System.out.println(passPorEncriptar);		
		this.passwordEncriptada = DigestUtils.sha256Hex(passPorEncriptar);
	}
	public void validarUnUsuario(String nombre, String password) {
		var passPorEncriptar = String.join("__", password, salt);
		if (DigestUtils.sha256Hex(passPorEncriptar).equals(this.passwordEncriptada)) {
			System.out.println("Las passwords coinciden");
			return;
		}
		System.out.println("Las passwords NO coinciden");
		System.out.println(DigestUtils.sha256Hex(passPorEncriptar));
		System.out.println(this.passwordEncriptada);
	}
	public String toString() {
		return this.nombre + " " + this.passwordEncriptada; 
	}
}
