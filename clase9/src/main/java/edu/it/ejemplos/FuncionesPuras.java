package edu.it.ejemplos;

public class FuncionesPuras {
	public static Boolean esDivisible(Long dividendo, Long divisor) {
		return (dividendo % divisor == 0);
	}
	public static Boolean esPar(Long x) {
		 return (x % 2 == 0);
	}
	public static Boolean esPar(int x) {
		 return (x % 2 == 0);
	}
	public static void dormir() {
		try { Thread.sleep(10); } catch (Exception ex) {}
	}
}
