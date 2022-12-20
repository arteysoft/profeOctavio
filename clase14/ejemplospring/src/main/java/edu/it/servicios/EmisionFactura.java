package edu.it.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmisionFactura {
	
	@Autowired
	CalculoIva calculoIva;
	
	public void emitirFactura() {
		System.out.println("Calculando el iva");
		System.out.println(calculoIva.calcularIva());
		System.out.println("Generando pdf");		
	}
}
