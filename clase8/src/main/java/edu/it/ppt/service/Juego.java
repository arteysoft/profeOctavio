package edu.it.ppt.service;

import java.util.HashMap;

import edu.it.ppt.enums.ELEMENTOS;

public class Juego {
	private PPTReader jugador1;
	private PPTReader jugador2;
	private HashMap<DuplaElementos, Integer> preComp = new HashMap<>();
	
	public Juego(PPTReader jugador1, PPTReader jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		
		preComp.put(new DuplaElementos(ELEMENTOS.PIEDRA, ELEMENTOS.PAPEL), 2);
		preComp.put(new DuplaElementos(ELEMENTOS.PIEDRA, ELEMENTOS.PIEDRA), 0);
		preComp.put(new DuplaElementos(ELEMENTOS.PIEDRA, ELEMENTOS.TIJERA), 1);
		
		preComp.put(new DuplaElementos(ELEMENTOS.PAPEL, ELEMENTOS.PAPEL), 0);
		preComp.put(new DuplaElementos(ELEMENTOS.PAPEL, ELEMENTOS.PIEDRA), 1);
		preComp.put(new DuplaElementos(ELEMENTOS.PAPEL, ELEMENTOS.TIJERA), 2);
		
		preComp.put(new DuplaElementos(ELEMENTOS.TIJERA, ELEMENTOS.PAPEL), 1);
		preComp.put(new DuplaElementos(ELEMENTOS.TIJERA, ELEMENTOS.PIEDRA), 2);
		preComp.put(new DuplaElementos(ELEMENTOS.TIJERA, ELEMENTOS.TIJERA), 0);
	}

	/* 0 es empate, 1 es gana jugador 1, 2 gana jugador 2*/
	public Integer jugar() {
		var seleccion1 = jugador1.read();
		var seleccion2 = jugador2.read();
		
		System.out.println("Jugador 1 selecciono: " + seleccion1.toString());
		System.out.println("Jugador 2 selecciono: " + seleccion2.toString());
		
		return preComp.get(new DuplaElementos(seleccion1, seleccion2));
	}
}
