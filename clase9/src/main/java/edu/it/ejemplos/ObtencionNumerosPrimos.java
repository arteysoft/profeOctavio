package edu.it.ejemplos;

import java.util.HashSet;

/*
 * En la consola del input... pasarle un rango de numeros posbibles. desde hasta.
 * Si no esta en ese rango, ahi tirar la exception
 */


public class ObtencionNumerosPrimos {	
	HashSet<Long> setDeNumerosPrimos = new HashSet<Long>();
	
	private void verificarNumero(Long averificar) {
		for (Long divisor : setDeNumerosPrimos) {
			System.out.print(".");
			if (FuncionesPuras.esDivisible(averificar, divisor)) {
				System.out.println("NOPE");
				return;
			}
		}
		System.out.println();
		System.out.println(averificar);
		setDeNumerosPrimos.add(averificar);
	}
	private void obtenerNumerosPrimos() {
		setDeNumerosPrimos.add(2l);
		for (Long averificar = 3l; averificar < Long.MAX_VALUE ;averificar++) {
			verificarNumero(averificar);
			try { Thread.sleep(averificar / 10); } catch (Exception ex) {}
		}
	}
	public void run() {
		obtenerNumerosPrimos();
	}
}
