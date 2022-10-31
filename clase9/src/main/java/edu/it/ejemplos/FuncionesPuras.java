package edu.it.ejemplos;

public class FuncionesPuras {
	public static Boolean esDivisible(Long dividendo, Long divisor) {
		if (dividendo % divisor == 0) {
			return true;
		}
		return false;
	}
}
