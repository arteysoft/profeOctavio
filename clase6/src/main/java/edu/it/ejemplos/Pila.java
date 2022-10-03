package edu.it.ejemplos;

public class Pila implements Runnable {
	// private m6
	public void m6(Integer x) {
		// Voy a validar si x == 0
		// eso es porque quiero dividir
		Integer num = 50000 / x;
		System.out.println("La division es: " + num);
	}
	// private m5
	// private m4
	// private m3
	// private m2
	private void m1(Integer x) {
		System.out.println("Antes de llamar a m2");
		// m2(x + 1)
		System.out.println("Despues de llamar a m2");
	}
	public void run() {
		System.out.println("Ejercicio de la pila o Stack");
		m1(1000);
	}
}
