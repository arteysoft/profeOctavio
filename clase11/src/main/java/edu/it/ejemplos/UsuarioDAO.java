package edu.it.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;

import edu.it.dto.Usuario;
import edu.itutiles.Utiles;

public class UsuarioDAO {
	private java.sql.Connection conn = null;
	
	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	public void realizarUnInsert(Usuario usu) {
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
	public void realizarUnUpdate(Usuario usu) {
		// Pasos a seguir
		// 1) Probar el update en el mysql 
		// update usuarios set nombre = 'SARASA' where id = 'unIDDeterminado'
		// 2) Considerar que el id, es el campo usu.id que viene en el objeto
		// 3) Dado que NO conozco todo lo que se cambio, tengo que actualizar todo el objeto.
		// El resto ? es igual que realizar un insert
	}
	public void run() {
		try {
			var usuario = Utiles.crearUsuarioRandom();			
			// realizarUnInsert(usuario);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
