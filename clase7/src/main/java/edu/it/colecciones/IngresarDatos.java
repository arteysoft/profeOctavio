package edu.it.colecciones;

import java.util.ArrayList;
import java.util.Scanner;

public class IngresarDatos {
	private void cargarArrayList(ArrayList<String> lista) {
		System.out.println("Ingrese algo que quiera: ");
		var scn = new Scanner(System.in);
		String str = scn.nextLine();
		lista.add(str);
	}
	public void run() {
		var lista = new ArrayList<String>();
		
		for (int x : new int[4]) {
			cargarArrayList(lista);
		}
		
		System.out.println("------------------------------------");
		System.out.println("AHORA SE MUESTRA TODO JUNTO         ");
		System.out.println("------------------------------------");
		
		for (String s : lista) {
			System.out.println(s);
		}
	}
}
