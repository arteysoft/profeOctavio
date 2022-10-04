package edu.it.ejemplos;

public class DesbordamientoDePila implements Runnable {
	private void m1(Integer x) {
		System.out.println("Antes de llamar a m2: " + x);
		m1(x + 1);		
		System.out.println("Despues de llamar a m2");
	}
	public void run() {
		System.out.println("Ejercicio de la pila o Stack");
		try {
			m1(0);	
		}
		catch (Error ex) {
			try { Thread.sleep(10000); } catch (Exception ex2) {}
			System.out.println("StackOverflow");
		}		
		System.out.println("Sigue la aplicacion normalmente");
	}
}
