<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>
	<h1>
	<c:out value="Hello DOA 1"/>
	</h1>
	

	<ul>
		<c:forEach items="${resultat}" var="etudiant">
			<li><c:out value="${etudiant.nom}"></c:out></li>
		</c:forEach>
	</ul>
	
	<p>	
<!-- 	<form action="/dao1" method="post"> -->
<!-- 		<label id="id">Identifiant</label> -->
<!-- 		<input type="text" id="id" name="id"> -->
<!-- 		<br/> -->
<!-- 		<label id="nom">Nom</label> -->
<!-- 		<input type="text" id="nom" name="nom"> -->
<!-- 		<br/> -->
<!-- 		<label id="prenom">Prénom</label> -->
<!-- 		<input type="text" id="prenom" name="prenom"> -->
<!-- 		<br/> -->
<!-- 		<input type="submit" value="Envoyer"> -->
<!-- 	</form> -->
	</p>
</body>
</html>