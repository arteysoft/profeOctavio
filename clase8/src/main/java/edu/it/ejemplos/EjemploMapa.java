package edu.it.ejemplos;

import java.util.HashMap;
import java.util.Objects;

class LaKey {
	Integer uno;
	Integer dos;
	
	public LaKey(Integer uno, Integer dos) {
		this.uno = uno;
		this.dos = dos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dos, uno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaKey other = (LaKey) obj;
		return Objects.equals(dos, other.dos) && Objects.equals(uno, other.uno);
	}
}

public class EjemploMapa {
	private HashMap<LaKey, Integer> mapaSuma = new HashMap<LaKey, Integer>();
	
	// MEMOIZE
	private Integer sumar(Integer x, Integer y) {
		Integer resultado = mapaSuma.get(new LaKey(x, y));
		
		if (resultado == null) {
			System.out.println("No existia previamente esa operacion");
			mapaSuma.put(new LaKey(x, y), x + y);
		}
		else {
			System.out.println("Si existia previamente");
			System.out.println("El resultado es: " + resultado);
		}
		
		return mapaSuma.get(new LaKey(x, y));
	}
	public void run() {
		System.out.println(sumar(3, 5));
		System.out.println(sumar(2, 5));
		System.out.println(sumar(3, 5));
		System.out.println(sumar(55, 5));
		System.out.println(sumar(2, 5));
	}
}
