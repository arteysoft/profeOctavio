package edu.it.servicios;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.it.dto.Usuario;
import edu.itutiles.Utiles;

public class GrabadorUsuarios {
	private Connection conn = null;
	
	public GrabadorUsuarios() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/profeoctavio", 
					"root", "");
			
			System.out.println("Conexion Abierta");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void grabar(Usuario usu) {
		try {
			var stm = conn.prepareStatement("INSERT into usuarios VALUES (?,?,?,?,?,?)");
			stm.setString(1, usu.id);
			stm.setString(2, usu.nombre);
			stm.setString(3, usu.apellido);
			stm.setString(4, usu.domicilio);
			stm.setString(5, usu.pais);
			stm.setInt(6, usu.saldoCuenta);
			stm.execute();
		}
		catch (Exception ex) {
			var err = new RuntimeException("NO SE PUDO HACER EL INSERT");
			System.out.println(err.getMessage());
			throw err;
		}
	}
	
	public void cerrarConexion() {		
		try {
			conn.close();
		}
		catch (Exception ex) {
			
		}
	}
}
