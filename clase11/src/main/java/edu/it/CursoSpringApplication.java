package edu.it;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;

import edu.it.dto.Usuario;
import edu.it.ejemplos.ConnectionManager;
import edu.it.ejemplos.UsuarioDAO;
import edu.itutiles.Utiles;

@SpringBootApplication
public class CursoSpringApplication {
	public static void main(String... params) throws Exception {
		ConnectionManager connManager = new ConnectionManager();
		try {
			var conn = connManager.conectar();
			var usuarioDao = new UsuarioDAO(conn);
			var lista = usuarioDao.obtenerListaUsuario("nombre = 'Addie'");
			
			for (Usuario u : lista) {
				System.out.println(new Gson().toJson(u));
			}
			
			Utiles.intentarOperacion(() -> {
				System.out.println("Voy a cerrar conexion");
				conn.close();
			});
		}
		catch (edu.it.error.SQLException ex) {
			ex.printStackTrace();
		}
		catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}
}
