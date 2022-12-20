package edu.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import edu.it.repository.UsuarioRepository;
import edu.it.utiles.Utiles;

@Component
public class MainClass implements CommandLineRunner {
	
	@Autowired
	Utiles utiles;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10000; i++) {
			var usuario = utiles.crearUsuarioRandom();
			// usuario.id = "6e732f7d-ac05-4358-8edf-458ceb9044e9"; CAMBIAR POR ID QUE EXISTA
			System.out.println(new Gson().toJson(usuario));
			usuarioRepository.save(usuario);
		}
	}
}
