package edu.it.ejemplos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.it.dto.Usuario;
import edu.itutiles.Utiles;

public class UsuarioDAO {
	private java.sql.Connection conn = null;
	
	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	public List<Usuario> obtenerListaUsuario(String condicion) {
		var listaUsuarios = new ArrayList<Usuario>();
		try {
			var stm = conn.prepareStatement("SELECT * FROM usuarios WHERE " + condicion);
			var rs = stm.executeQuery();
			while (rs.next()) {
				var usu = new Usuario();
				usu.id = rs.getString("id");
				usu.nombre = rs.getString("nombre");
				usu.apellido = rs.getString("apellido");
				usu.domicilio = rs.getString("domicilio");
				usu.pais = rs.getString("pais");
				usu.saldoCuenta = rs.getInt("saldo_cuenta");
				
				listaUsuarios.add(usu);				
			}
			return listaUsuarios;
		}
		catch (Exception ex) {
			var err = new RuntimeException("NO SE PUDO HACER EL SELECT");
			System.out.println(err.getMessage());
			throw err;
		}
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
		String strSQL = "UPDATE usuarios set nombre = ?, apellido = ?, domicilio = ?, pais = ?, saldo_cuenta = ? ";
		strSQL += "WHERE id = ?";
		
		try {
			var stm = conn.prepareStatement(strSQL);
			stm.setString(1, usu.nombre);
			stm.setString(2, usu.apellido);
			stm.setString(3, usu.domicilio);
			stm.setString(4, usu.pais);
			stm.setInt(5, usu.saldoCuenta);
			stm.setString(6, usu.id);
			
			stm.execute();
		}
		catch (Exception ex) {
			var err = new RuntimeException("NO SE PUDO HACER EL UPDATE");
			System.out.println(err.getMessage());
			throw err;
		}
	}
	public void realizarDelete(String id) {
		String strSQL = "DELETE FROM usuarios WHERE id = ? ";
		
		try {
			var stm = conn.prepareStatement(strSQL);
			stm.setString(1, id);
			stm.execute();
		}
		catch (Exception ex) {
			var err = new RuntimeException("NO SE PUDO HACER EL UPDATE");
			System.out.println(err.getMessage());
			throw err;
		}
	}
	public void run() {
		try {
			var usuario = Utiles.crearUsuarioRandom();			
			// realizarUnInsert(usuario);
			usuario.id = "02899359-51aa-4bd0-93ef-a580d820f02c";
			// realizarUnUpdate(usuario);
			realizarDelete(usuario.id);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
