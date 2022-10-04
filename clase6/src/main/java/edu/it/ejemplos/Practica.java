package edu.it.ejemplos;

public class Practica implements Runnable {
	private void fnThrowChecked() throws Exception {
		throw new Exception("Este es un simple Exception");
	}
	private void fnThrowUnChecked() {
		throw new RuntimeException("Este es un runtime exception");
	}
	public void run() {
		try {
			fnThrowChecked();
		}
		catch (Exception ex) {
			System.out.println("Ya en el catch... " + ex.getMessage());
		}
	}
}
