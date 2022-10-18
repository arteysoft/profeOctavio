package com.lucasdelamer.ww.clase07;

public class Banco {
	
	public Banco() {
	
	
}
	public double tasaBanco (double tasaAnualBanco, double periodos, double montoInicial){
    	
    	
    	double montoFinal;
    	
    	montoFinal = montoInicial * (Math.pow((1 +(tasaAnualBanco/12)),periodos)); 
    	
    	return montoFinal;
    	
    }
}

