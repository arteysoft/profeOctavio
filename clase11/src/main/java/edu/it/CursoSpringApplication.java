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
			var imprimeBorra = new edu.it.servicios.ImprimePorConsolaOpcionBorrado(usuarioDao);
			
			// Quiero que pasen el nombre como parametro. params[0] tendria que venir cargado con el nombre
			// Se lo voy a pasar el run como parametro tb. y el run como parametro al string. 
			// en vez de dejarlo como addie, lo parametrizo.
			imprimeBorra.run();
			
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
