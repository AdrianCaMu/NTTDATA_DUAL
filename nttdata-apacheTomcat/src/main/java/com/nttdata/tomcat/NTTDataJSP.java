package com.nttdata.tomcat;

/**
 * Clase para probar JSP
 * @author Adrian Camara Munoz
 *
 */
public class NTTDataJSP {
	
	/**
	 * Constructor por defecto
	 */
	public NTTDataJSP() {
		
	}
	
	/**
	 * Metodo encargado de saludar al usuario solicitado
	 * @param name nombre del usuario a saludar
	 * @return String saludo
	 */
	public static String helloNTTData(String name) {
		String s = "Bienvenid@ " + name + " !!";
		return s;
	}
	
}
