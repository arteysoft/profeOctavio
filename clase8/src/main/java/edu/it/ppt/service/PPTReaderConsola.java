package edu.it.ppt.service;

import java.util.Scanner;

import edu.it.ppt.enums.ELEMENTOS;

public class PPTReaderConsola implements PPTReader {
	public static ELEMENTOS ObtenerElementoSegunInteger(Integer x) {
		System.out.println(x);
		switch (x) {
		case 1:
			return ELEMENTOS.PIEDRA;
		case 2:
			return ELEMENTOS.PAPEL;
		case 3:
			return ELEMENTOS.TIJERA;
		default:
			throw new RuntimeException("NO DEBERIA LLEGAR HASTA ACA CON UN VALOR DIFERENTE DE 1|2|3");
		}
	}
	public ELEMENTOS read() {
		Integer res = 0;
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese ");
		System.out.println("1. Piedra");
		System.out.println("2. Papel");
		System.out.println("3. Tijera");
		var str = scn.nextLine();
		try {
			res = Integer.parseInt(str);
			if (res > 3 || res < 1) {
				throw new RuntimeException();
			}
		}
		catch (Exception ex) {
			System.out.println("Debe ingresar datos del 1 al 3");
			return read();
		}
		
		return ObtenerElementoSegunInteger(res);
	}
}
