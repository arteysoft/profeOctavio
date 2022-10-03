package edu.it.ejemplos;

public class Pila implements Runnable {
	// private m6
	public void m6(Integer x) {
		// Voy a validar si x == 0
		// eso es porque quiero dividir
		if (x == 0) {
			throw new RuntimeException("Atencion que no se puede proseguir... division por zero");
		}
		Integer num = 50000 / x;
		System.out.println("La division es: " + num);
		for (StackTraceElement elem : new Throwable().getStackTrace()) {
			//System.out.println("Nombre: " + elem.getMethodName());
			//System.out.println("Linea: " + elem.getLineNumber());
		}
	}
	private void m5(Integer x) {
		System.out.println("Antes de llamar a m6");
		m6(x + 1);
		System.out.println("Despues de llamar a m6");
	}
	private void m4(Integer x) {
		System.out.println("Antes de llamar a m5");
		m5(x + 1);
		System.out.println("Despues de llamar a m5");
	}
	private void m3(Integer x) {
		System.out.println("Antes de llamar a m4");
		m4(x + 1);
		System.out.println("Despues de llamar a m4");
	}
	private void m2(Integer x) {
		System.out.println("Antes de llamar a m3");
		m3(x + 1);
		System.out.println("Despues de llamar a m3");
	}
	private void m1(Integer x) {
		System.out.println("Antes de llamar a m2");
		m2(x + 1);
		System.out.println("Despues de llamar a m2");
	}
	public void run() {
		try {
			System.out.println("Ejercicio de la pila o Stack");
			// Vamos a iterar desde -10 hasta 10 y solo va fallar una de las iteraciones			
			{
				m1(-5);
				Thread.sleep(2000);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Sigue la aplicacion normalmente");
	}
}
