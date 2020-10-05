<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Menu.jsp" %>
	<h1>Cours Réseaux...</h1>
	Bonjour
	<%
	String nom = (String)request.getAttribute("nom");
	String prenom = (String)request.getAttribute("prenom");
	out.println(nom + " " + prenom);
	%>
	, et bienveunu au cours de reseaux...
	<br/>
	<br/>
	
	<p>
	Bonjour ${nom} ${prenom}.
	<br/>
	${table[0]} ${table[1]} ${table[2]}
	<br/>
	${!empty nom ? nom : "Parametre nom invalide!"}
	</p>
</body>
</html>