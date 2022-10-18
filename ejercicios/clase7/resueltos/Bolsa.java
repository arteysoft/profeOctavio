package com.lucasdelamer.ww.clase07;

public class Bolsa {
	
	public Bolsa() {
		
	}
	
public double TasaBolsa(double tasaAnualBolsa, double periodos, double montoInicial) {
	
	double montoFinal =  montoInicial * (Math.pow((1 +(tasaAnualBolsa/365)),periodos)); 
	
	return montoFinal;
		
	}
	
	

}
