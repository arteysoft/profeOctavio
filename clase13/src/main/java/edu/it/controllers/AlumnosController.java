package edu.it.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import edu.it.entities.Alumno;

public class AlumnosController extends HttpServlet {
	Logger logger = Logger.getLogger(getClass());
	private static List<Alumno> lstAlumno = new ArrayList<Alumno>();
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    	throws IOException, ServletException {
    	
    	response.setContentType("application/json");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println(new Gson().toJson(lstAlumno));
    	
    	response.setStatus(200);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        	throws IOException, ServletException {
    	
        	response.setContentType("application/json");
        	
        	PrintWriter out = response.getWriter();
        	
        	InputStream is = request.getInputStream();
        	InputStreamReader isr = new InputStreamReader(is);
        	BufferedReader br = new BufferedReader(isr);
        	
        	StringBuilder strBld = new StringBuilder();
        	
        	for (String linea = br.readLine(); linea != null;linea = br.readLine()) {
        		strBld.append(linea);
        	}
        	
        	try {
        		var alumno = new Gson().fromJson(strBld.toString(), Alumno.class);
        		lstAlumno.add(alumno);
        		response.setStatus(201);
        	}
        	catch (Exception ex) {
        		response.setStatus(400);
        	}
    }
    
    public void doPut(HttpServletRequest request, HttpServletResponse response) 
        	throws IOException, ServletException {
    	
    	Alumno alumno = null;
    	
    	response.setContentType("application/json");
    	
    	PrintWriter out = response.getWriter();
    	
    	InputStream is = request.getInputStream();
    	InputStreamReader isr = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(isr);
    	
    	StringBuilder strBld = new StringBuilder();
    	
    	for (String linea = br.readLine(); linea != null;linea = br.readLine()) {
    		strBld.append(linea);
    	}
    	
    	try {
    		alumno = new Gson().fromJson(strBld.toString(), Alumno.class);
    	}
    	catch (Exception ex) {
    		response.setStatus(400);
    		return;
    	}
    	
    	String idSolo = request.getPathInfo().replace("/", "");
    	
    	if (idSolo.length() != 36) {
    		response.setStatus(400);
    		return;
    	}
    	
    	var found = lstAlumno
        		.stream()
        		.filter(z -> z.id.equalsIgnoreCase(idSolo))
        		.collect(Collectors.toList());
        	
    	if (found.size()==0) {
    		response.setStatus(404);
    		return;
    	}
    	
    	found.get(0).id = alumno.id;
    	found.get(0).nombre = alumno.nombre;
    	found.get(0).apellido = alumno.apellido;
    	found.get(0).calle = alumno.calle;
    	found.get(0).calleNumero = alumno.calleNumero;
    	found.get(0).estado = alumno.estado;
    	found.get(0).pais = alumno.pais;
    	
        response.setStatus(200);
    }
    
    public void doDelete(HttpServletRequest request, HttpServletResponse response) 
        	throws IOException, ServletException {
    	
    	String idSolo = request.getPathInfo().replace("/", "");
    	
    	if (idSolo.length()!=36) {
    		response.setStatus(400);
    		return;
    	}
    	
    	System.out.println(idSolo);
    	
    	lstAlumno = lstAlumno
    		.stream()
    		.filter(z -> z.id.equalsIgnoreCase(idSolo) == false)
    		.collect(Collectors.toList());
    	
    	response.setStatus(200);
    }
}
