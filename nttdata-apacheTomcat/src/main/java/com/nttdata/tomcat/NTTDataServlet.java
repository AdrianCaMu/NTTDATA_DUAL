package com.nttdata.tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Primer Servlet dual NTTDataServlet
 * @author Adrian Camara Munoz
 */
public class NTTDataServlet extends HttpServlet {
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
       
    /**
     * constructor por defecto
     * @see HttpServlet#HttpServlet()
     */
    public NTTDataServlet() {
        super();
    }

	/**
	 * Metodo que escucha peticiones HTTP con método GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\nBIENVENIDO");
	}

	/**
	 * Metodo que escucha peticiones HTTP con método POST
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
