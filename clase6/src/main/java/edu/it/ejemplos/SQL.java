package edu.it.ejemplos;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL implements Runnable {
	public void m6(Integer x) throws SQLException {
		var esNull = DriverManager.getConnection("holaquetal");
		System.out.println("Es null: " + esNull);
	}
	private void m5(Integer x) throws SQLException {
		System.out.println("Antes de llamar a m6");
		try {
			m6(x + 1);
		}
		catch (SQLException ex) {
			throw ex;
		}
		System.out.println("Despues de llamar a m6");
	}
	private void m4(Integer x) throws SQLException {
		System.out.println("Antes de llamar a m5");
		m5(x + 1);
		System.out.println("Despues de llamar a m5");
	}
	private void m3(Integer x) throws SQLException {
		System.out.println("Antes de llamar a m4");
		m4(x + 1);
		System.out.println("Despues de llamar a m4");
	}
	private void m2(Integer x) throws SQLException {
		System.out.println("Antes de llamar a m3");
		m3(x + 1);
		System.out.println("Despues de llamar a m3");
	}
	private void m1(Integer x) throws SQLException {
		System.out.println("Antes de llamar a m2");
		m2(x + 1);
		System.out.println("Despues de llamar a m2");
	}
	public void run() {
		System.out.println("Ejercicio de la pila o Stack");
		
		try {
			m1(0);	
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Sigue la aplicacion normalmente");
	}
}
