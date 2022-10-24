package edu.it.ppt.service;

public class Juego {
	private PPTReader jugador1;
	private PPTReader jugador2;
	
	/* 0 es empate, 1 es gana jugador 1, 2 gana jugador 2*/
	public Integer jugar() {
		var seleccion1 = jugador1.read();
		var seleccion2 = jugador2.read();
		
		// Logica para dar con el ganador
		
		return 0;
	}
}
