package edu.it.ppt.service;

import edu.it.ppt.enums.ELEMENTOS;

public class Juego {
	private PPTReader jugador1;
	private PPTReader jugador2;
	
	public Juego(PPTReader jugador1, PPTReader jugador2) {
		super();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	/* 0 es empate, 1 es gana jugador 1, 2 gana jugador 2*/
	public Integer jugar() {
		var seleccion1 = jugador1.read();
		var seleccion2 = jugador2.read();
		
		System.out.println("Jugador 1 selecciono: " + seleccion1.toString());
		System.out.println("Jugador 2 selecciono: " + seleccion2.toString());
		
		if (seleccion1 == seleccion2) {			
			return 0;
		}

		return 1;
	}
}
