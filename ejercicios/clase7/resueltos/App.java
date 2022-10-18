package com.lucasdelamer.ww.clase07;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	
    Scanner teclado = new Scanner(System.in);	
    
    double capitalInicial;	
    double tnaBco;
    double tnaBolsa;
    double periodosBanco;
    double periodosBolsa;
    
     System.out.println("ingresar capital inicial");
    
     capitalInicial = teclado.nextDouble();
    
     System.out.println("ingresar tna banco");
    
     tnaBco = (teclado.nextDouble())/100;
     
     System.out.println("ingresar tna bolsa");
     
     tnaBolsa = (teclado.nextDouble())/100;
     
     System.out.println("ingresar periodos banco");
     
     periodosBanco = teclado.nextDouble();
     
     System.out.println("ingresar periodos bolsa");
     
     periodosBolsa = teclado.nextDouble();         
    	
     Banco banco = new Banco();
     
     double resultado = banco.tasaBanco(tnaBco, periodosBanco, capitalInicial);
     
     System.out.println("interes pagado en banco : " + (resultado - capitalInicial));      
     
     Bolsa bolsa = new Bolsa();
     
     double resultado2 = bolsa.TasaBolsa(tnaBolsa,periodosBolsa,capitalInicial);
     
     System.out.println("interes pagado en bolsa : " + (resultado2 - capitalInicial));     
     
     teclado.close();
    }         
}

