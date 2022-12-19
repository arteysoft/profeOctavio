package edu.it;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.it.servicios.ManagerUsuario;

@SpringBootApplication
public class CursoSpringApplication {
	public static void main(String... params) throws Exception {
		ManagerUsuario managerUsuario = new ManagerUsuario();
		managerUsuario.crearUnUsuario("Andy", "Messi");
		managerUsuario.validarUnUsuario("Andy", "Messi");
		System.out.println(managerUsuario);
	}
}
