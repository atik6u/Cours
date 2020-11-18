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

	<c:out value="Bonjour ${nom}" escapeXml="false"></c:out>

	<c:set var="prenom" value="Mohammed" scope="page"></c:set>
	<!--  Portee les variables (attribut scope)-->

	<p>
		<c:out value="prenom: ${prenom}"></c:out>
	</p>

	<!-- Declarer une variable x=14 -->
	<p>
		<c:set var="x"> 14 </c:set>
		<c:out value="x = ${x}"></c:out>
	</p>

	<!-- Modifier la variable -->
	<p>
		<c:set var="x"> 21 </c:set>
		<c:out value="valeur x  apres modif = ${x}"></c:out>
	</p>

	<p>
		<c:remove var="x" scope="page" />
		<c:out value="valeur x  apres remove = ${x}"></c:out>
	</p>

	<!-- Traitement d'un objet -->
	<p>
		<c:out value="Etudiant: ${etudiant.nom} ${etudiant.prenom}"></c:out>
	</p>

	<!-- Modification d'un objet -->

	<p>
		<c:set target="${etudiant}" property="nom" value="pas ATIK"></c:set>
		<%-- 		<c:set target="${etudiant}" property="nom">KITA</c:set> --%>
		<!-- Meme que la ligne avant	 -->
		<c:out
			value="Etudiant apres modif: ${etudiant.nom} ${etudiant.prenom}"></c:out>
	</p>

	<!-- Fair la somme de deux parametre recuperes dans une requete GET -->
	<p>
		<c:out
			value="La somme des deux parametres a et b est: ${a} + ${b} = ${a+b}"></c:out>
	</p>

	<!-- Tests avec JSTL -->
	<p>
		<c:if test="${1==1}" var="tester">
			<h5>Le test est verifie</h5>
		</c:if>
	</p>

	<p>
		<c:if test="${!tester}">
	Je teste la variable tester
	</c:if>
	</p>

	<!-- choix multiple -->
	<c:choose>
		<c:when test="${1!=1}">Test 1=1</c:when>
		<c:when test="${2!=2}">Test 2=2</c:when>
		<c:when test="${3!=3}">Test 3=3</c:when>
		<c:when test="${4!=4}">Test 4=4</c:when>
		<c:otherwise>Aucun test n'est verifie</c:otherwise>
	</c:choose>

	<p>
		<c:out
			value="#####################################Formulaire #####################################"></c:out>
	</p>

	<p>
		<c:if test="${authentification.isConnexion()}" var="tester">
			<h5>Vous etes connecte</h5>
		</c:if>
	</p>
	<form action="" method="post">

		<label for="login">Login: </label> 
		<input type="text" id="login" name="login" />
		<br/>
		<label for="pass">password: </label>
		<input type="password" id="pass" name="pass" />
		<br />
		<input type="submit" name="connexion"/>

	</form>
	
	<c:forEach var="i" begin="0" end="4" step="1">	
	<p>
	<c:out value="Bonjour ${i}"></c:out>
	</p>
	</c:forEach>
	
	<p>
	<c:out value="Parcourir une liste d'etudiants"></c:out>
	</p>
	
	<c:forEach items="${listeEtudiants}" var="etudiant">	
	<p>
	<c:out value="${etudiant}"></c:out>
	</p>
	</c:forEach>

</body>
</html>