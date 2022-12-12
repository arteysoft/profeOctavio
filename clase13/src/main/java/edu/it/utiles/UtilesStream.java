package edu.it.utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UtilesStream {
	public static String leerInputStream(InputStream is) throws IOException {
		InputStreamReader isr = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(isr);
    	
    	StringBuilder cont = new StringBuilder();

    	for (String linea = br.readLine();
    			linea != null; linea = br.readLine()) {
    		cont.append(linea);
    	}
    	
    	return cont.toString();
	}
}
