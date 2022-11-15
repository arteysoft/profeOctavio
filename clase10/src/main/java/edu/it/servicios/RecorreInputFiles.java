package edu.it.servicios;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import edu.it.dto.Usuario;

public class RecorreInputFiles {
	private GrabadorUsuarios grabadorSQL;
	
	public RecorreInputFiles(GrabadorUsuarios grabadorSQL) {
		this.grabadorSQL = grabadorSQL;
	}

	public void run() {
		String folderNuevos = "/var/profeoctavio/usuarios/nuevos";
		String folderErroresSQL = "/var/profeoctavio/usuarios/erroressql";
		String folderErroresArch = "/var/profeoctavio/usuarios/erroresarch";
		
		File ffolderNuevos = new File(folderNuevos);
		File[] arrNuevosArchivos = ffolderNuevos.listFiles();
		
		for (File factual : arrNuevosArchivos) {
			String contenido = null;
			Usuario usu = null; 
			
			try {
				contenido = FileUtils.readFileToString(factual, "utf-8");				
			}
			catch (Exception ex) {
				System.out.println("No se puede leer el archivo: " + factual.getAbsolutePath());
			}
			
			try {
				usu = new Gson().fromJson(contenido, Usuario.class);
			}
			catch (Exception ex) {
				ex.printStackTrace();
				for (StackTraceElement ste : ex.getStackTrace()) {
					// logger.erro(ste)
					System.out.println(ste.toString());
				}
				factual.renameTo(new File("/var/profeoctavio/usuarios/erroresarch/" + "hola" + ".json"));
			}
			
			try {
				grabadorSQL.grabar(usu);
			}
			catch (Exception ex) {
				System.out.println("No se pudo grabar en SQL");
				factual.renameTo(new File("/var/profeoctavio/usuarios/erroressql/" + usu.id + ".json"));
			}
			
			try {
				factual.delete();
			}
			catch (Exception ex) {
				System.out.println("No se pudo borrar el archivo");
			}
			
			try {
				Thread.sleep(3);
			}
			catch (Exception ex) {
				
			}
		}
	}
	
	
	/* 
	 * Leer archivo 
	 * Si puedo grabarlo en SQL ? 
	 *   Borrar archivo
	 * Si NO puedo grabarlo en SQL
	 *   mover el archivo a una carpeta de errores
	 * Si no puedo leer el archivo.
	 *   Ponerlo en alguna lista en memoria
	 */
}
