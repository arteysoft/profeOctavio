package edu.it.utiles;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.dto.ResultadoError;
import edu.it.dto.ResultadoOK;
import edu.it.errores.HttpException;

public class UtilesHTTP {
	public static void controlarRespuesta(
			HttpServletResponse response,
			Runnable fn
			) {
		
		PrintWriter out = null;
		
		try {
			response.setContentType("application/json");
			out = response.getWriter();
			fn.run();
		}
		catch (HttpException httpEx) {
			var z = resolverPorError(httpEx.getMessage());
        	out.println(z);
        	response.setStatus(httpEx.status);
        }
        catch (Exception ex) {
        	var z = resolverPorError("Runtime");
        	out.println(z);
        	response.setStatus(500);
        }
	}
	public static String resolverPorOk(String mensaje) {
		Object z = new ResultadoOK(mensaje);
    	return new Gson().toJson(z);
	}
	public static String resolverPorError(String mensaje) {
		Object z = new ResultadoError(mensaje);
    	return new Gson().toJson(z);
	}
}
