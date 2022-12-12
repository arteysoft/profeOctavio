package edu.it.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
        	
        	var alumno = new Gson().fromJson(strBld.toString(), Alumno.class);
        	
        	lstAlumno.add(alumno);
        	
        	response.setStatus(201);
        }
    
}
