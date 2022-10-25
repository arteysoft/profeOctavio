package edu.it.ejemplos;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

import edu.it.ppt.enums.ELEMENTOS;

class Punto {
	public final Integer x;
	public final Integer y;
	public Punto(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Objects.equals(x, other.x) && Objects.equals(y, other.y);
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
}

public class EjemploSet {
	public void run() {
		System.out.println(UUID.randomUUID().toString());
		
		HashSet<Punto> puntos = new HashSet<>();
		
		puntos.add(new Punto(5, 3));
		puntos.add(new Punto(5, 3));
		puntos.add(new Punto(5, 3));
		puntos.add(new Punto(5, 3));
		puntos.add(new Punto(5, 4));
		
		for (Punto p : puntos) {
			System.out.println(p);
		}		
	}
}
