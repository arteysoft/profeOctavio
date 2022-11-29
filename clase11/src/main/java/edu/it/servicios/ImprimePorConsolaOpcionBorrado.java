package edu.it.servicios;

import java.util.Scanner;

import com.google.gson.Gson;

import edu.it.dto.Usuario;
import edu.it.ejemplos.UsuarioDAO;

public class ImprimePorConsolaOpcionBorrado {
	private UsuarioDAO usuarioDAO = null;

	public ImprimePorConsolaOpcionBorrado(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void run() {
		var lista = usuarioDAO.obtenerListaUsuario("nombre = 'Addie'");
		
		Scanner scn = new Scanner(System.in);
		
		for (Usuario u : lista) {			
			System.out.println(new Gson().toJson(u));
			System.out.println("Borra ? s/n");
			String linea = scn.nextLine();
			if (linea.equalsIgnoreCase("s")) {
				usuarioDAO.realizarDelete(u.id);
				System.out.println("Usuario borrado !!!");
			}
		}
	}
}
