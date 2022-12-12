package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import edu.it.basededatos.UtilesAlumno;
import edu.it.entities.Alumno;

public class InventarAlumnoController extends HttpServlet {
	Logger logger = Logger.getLogger(getClass());
	private static List<Alumno> lstAlumno = new ArrayList<Alumno>();
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    	throws IOException, ServletException {
    	
    	List<Alumno> lstAlumno = new ArrayList<Alumno>();
    	
    	response.setContentType("application/json");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println(new Gson().toJson(UtilesAlumno.generarAlumnoRandom()));
    	
    	response.setStatus(200);
    }
}
