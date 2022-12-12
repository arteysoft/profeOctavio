package edu.it.errores;

public class MethodNotAllowed extends HttpException {
    public MethodNotAllowed() {
    	status = 405;
        this.mensaje = "MethodNotAllowed";
    }
}
