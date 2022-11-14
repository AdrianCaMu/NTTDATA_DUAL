<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.nttdata.tomcat.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NTT Data Apache Tomcat – JSP </title>
</head>
<body>
	<h1>ESTO ES UNA PRUEBA DE JSP</h1>
	
	<%

	out.println("Esto es una cuenta de " + 5 + "...");

	for(int i=4; i>0; i--){
		out.println(i + "...");
	}
	
	out.println("YAAA!");
	
	%>
	
	<p><%= NTTDataJSP.helloNTTData("Manolo el pruebas") %></p>
	
</body>
</html>