package edu.it.errores;

public class UnauthorizedExeption extends HttpException{
	public UnauthorizedExeption(String mensaje) {
		status = 401;
		this.mensaje = mensaje;
	}
}

