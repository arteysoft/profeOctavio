package edu.it.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.itutiles.Utiles;

public class ConnectionManager {
	Connection conn = null;
	
	public Connection conectar() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/profeoctavio", 
					"root", "");
			
			System.out.println("Conexion Abierta");
			
			return conn;
		}
		catch (java.sql.SQLException ex) {
			throw new edu.it.error.SQLException();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
