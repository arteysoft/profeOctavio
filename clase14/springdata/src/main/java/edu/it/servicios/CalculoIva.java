package edu.it.servicios;

import org.springframework.stereotype.Component;

@Component
public class CalculoIva {
	public double calcularIva() {
		return 0.21d;
	}
}
