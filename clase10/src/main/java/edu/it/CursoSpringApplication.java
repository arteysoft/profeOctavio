package edu.it;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.it.servicios.GrabadorUsuarios;
import edu.it.servicios.RecorreInputFiles;

@SpringBootApplication
public class CursoSpringApplication {
	public static void main(String... params) throws Exception {
		var recorreFiles = new RecorreInputFiles(new GrabadorUsuarios());
		recorreFiles.run();
	}
}
