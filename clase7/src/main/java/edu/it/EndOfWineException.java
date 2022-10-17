package edu.it;

public class EndOfWineException extends RuntimeException {
	public final Integer cantidadRestante;
	public final String descripcion;
	
	public EndOfWineException(String descripcion, Integer cantidadRestante) {
		super();
		this.cantidadRestante = cantidadRestante;
		this.descripcion = descripcion;
	}
}
