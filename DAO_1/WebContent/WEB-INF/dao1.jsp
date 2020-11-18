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
	<h><c:out value="Hello DOA 1"/></h>
	</p>
	
	<p>
	<ul>
		<c:forEach items="${resultat}" var="etudiant">
			<li><c:out value="${etudiant.nom}"></c:out></li>
		</c:forEach>
	</ul>
	</p>
</body>
</html>