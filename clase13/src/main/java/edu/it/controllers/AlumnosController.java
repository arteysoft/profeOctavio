package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class AlumnosController extends HttpServlet {
	Logger logger = Logger.getLogger(getClass());
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    	throws IOException, ServletException {
    	
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println("<h1>Este markup NO se va a renderizar</h1>");
    	
    	response.setStatus(200);
    }
}
