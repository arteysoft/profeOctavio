package edu.it;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.it.ejemplos.LambdaExpressions;

@SpringBootApplication
public class CursoSpringApplication {
	public static void main(String... params) throws Exception {
		new LambdaExpressions().run();
	}
}
