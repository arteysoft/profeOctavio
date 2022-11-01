package edu.it.ejemplos;

interface Medicion {
	public void tomarTiempoInicio();
	public void ejecutar();
	public void tomarTiempoFin();
}

interface Calculo {
	Integer calcular(Integer x);
}

interface IntegerMostrable {
	void mostrar(Integer x);
}

interface Calculo2Params {
	Integer calcular(Integer uno, Integer dos);
}

interface Ejecutable {
	void ejecutar();
}

interface EjecucionEnLote {
	void ejecutar(Ejecutable[] ejecutables);
}

public class LambdaExpressions {
	Calculo calculo = x -> x + x + x;
	IntegerMostrable ver = x -> System.out.println(x);
	Calculo2Params calculo2params = (x, y) -> x + y;
	EjecucionEnLote ejecEnLote = (Ejecutable[] xs) -> {
		for (Ejecutable x : xs)
			x.ejecutar();		
	};
	Ejecutable hacerAlgo = () -> {
		System.out.println("Imprime algo por pantalla");
	};
	
	public void mostrarPorConsola(int x) {
		System.out.println(x);
	}
	public void run() {
		/*
		System.out.println("Estoy corriendo mi algoritmo");
		
		for (int x = 0; x < 100; x++) {
			ver.mostrar(calculo.calcular(x));
			FuncionesPuras.dormir();
		}
		System.out.println("Termine de correr mi algoritmo");
		*/
		
		ejecEnLote.ejecutar(new Ejecutable[] {
			() -> System.out.println("Primero esto"),
			() -> System.out.println("Despues esto"),
			() -> System.out.println("Luego esto"),
			() -> System.out.println("Por ultimo esto"),
		});
		
	}
	
}
