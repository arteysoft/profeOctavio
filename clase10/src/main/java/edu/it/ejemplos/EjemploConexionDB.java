package edu.it.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.it.dto.Usuario;
import edu.itutiles.Utiles;

public class EjemploConexionDB {
	public void realizarUnInsert(Connection conn, Usuario usu) {
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
	public void run() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/profeoctavio", 
					"root", "");
			
			System.out.println("Conexion Abierta");
			
			var usuario = Utiles.crearUsuarioRandom();
			
			realizarUnInsert(conn, usuario);
			
			System.out.println("Voy a cerrar conexion");
			conn.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
