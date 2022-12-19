package edu.it.ejemplos;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import edu.itutiles.Utiles;

public class VolcarUsuariosEnArchivos {
	private void guardarArchivo(String id, String usuJson) {
		var pathArchivo = String.join("", "/var/profeoctavio/usuarios/nuevos/", id, ".json");
		File file = new File(pathArchivo);
		try {
			FileUtils.writeStringToFile(file, usuJson, Charset.forName("utf-8"));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void run() {
		//var usuario = Utiles.crearUsuarioRandom();
		//var usuJson = new Gson().toJson(usuario);
		//System.out.println(usuJson);
		
		// bucle 
		// crearUnUsuarioRandom
		// crearUnArchivo con estas caracteristicas /var/profeoctavio/usuarios/nuevos/b2b27017-a5b4-415a-8eee-8c191572467d.json
		// dentro del archivo, vamos a tener el contenido del usuario en formato JSON
		
		for (int idx=0; idx < 5000; idx++) {
			var usuario = Utiles.crearUsuarioRandom();
			var usuJson = new Gson().toJson(usuario);
			guardarArchivo(usuario.id, usuJson);
		}
	}
}
