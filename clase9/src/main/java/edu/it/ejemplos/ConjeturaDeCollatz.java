package edu.it.ejemplos;

public class ConjeturaDeCollatz {
	public static int mitad(int x) {
		return (x / 2);
	}
	public static int tresnMasUno(int n) {
		return ((3 * n) + 1);
	}
	public static int verCantIteracionesPara(int numeroCalcular) {
		int contador=0;
		while (numeroCalcular > 1) {
			numeroCalcular = FuncionesPuras.esPar(numeroCalcular) ? 
						mitad(numeroCalcular) : tresnMasUno(numeroCalcular);
			
			contador=contador+1;
		}
		return contador;
	}
	public static void main(String[] args) {
		int numeroCalcular = 27;
		int contador = verCantIteracionesPara(numeroCalcular);
		
		System.out.println("el numero" + numeroCalcular + " fue necesario iterar" + contador + "para llegar a 1");
	}
	
	/*NICOLE*/
	 public static void collatz(int number) {
		System.out.println("result: ");
		if(number <= 2) {
			return;
		}
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
            System.out.print(number + " ");
        }
	 }
}
