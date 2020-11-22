<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
	<script type="text/javascript" src="DataTables/datatables.min.js"></script>
	
	<title>Base de données Etudiants</title>
</head>
<body>
	
	<div class="container" style="margin-top:30px">
	<p>
	<h1>
		<c:out value="Hello DOA 2" />
	</h1>
	
	<table class="table table-striped table-bordered tableetudiants" style="width:100%">
		<thead>
		<tr>
			<th scope="col">Identifiant</th>
			<th scope="col">Nom</th>
			<th scope="col">Prénom</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${resultat}" var="etudiant">
			<tr>
				<td><c:out value="${etudiant.id}"></c:out></td>
				<td><c:out value="${etudiant.nom}"></c:out></td>
				<td><c:out value="${etudiant.prenom}"></c:out></td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	<ul class="nav nav-tabs">
		<li class="nav-item">
			<a class="nav-link active" role="tab" data-toggle="tab" href="#ajouter">Ajouter un étudiant</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" role="tab" data-toggle="tab" href="#modifier">Modifier un étudiant</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" role="tab" data-toggle="tab" href="#supprimer">Supprimer un étudiant</a>
		</li>
	</ul>

	<div class="tab-content">
		<div class="tab-pane container active" id="ajouter" role="tabpanel">
			<h4 class="container mb-3 mt-3">Formulaire Ajouter Etudiant</h4>

			<form action="dao2" method="post">
				
				<div class="form-group row">
					<label id="id" class="col-sm-2 col-form-label">Identifiant:</label>
					<div class="col-sm-10">
						<input type="text" id="id" name="id" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label id="nom"  class="col-sm-2 col-form-label">Nom:</label>
					<div class="col-sm-10">
						<input type="text" id="nom" name="nom" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label id="prenom"  class="col-sm-2 col-form-label">Preom:</label>
					<div class="col-sm-10">
						<input type="text" id="nom" name="prenom" class="form-control">
					</div>
				</div>
				
				<input type="submit" name="submit" value="Ajouter" class="btn btn-primary">
			</form>
		</div>
		
		<div class="tab-pane container fade" id="modifier" role="tabpanel">
			<h4 class="container mb-3 mt-3">Formulaire modifier Etudiant</h4>
			<br/>
			<form action="dao2" method="post">
				<div class="form-group row">
					<label id="id" class="col-sm-2 col-form-label">Identifiant:</label>
					<div class="col-sm-10">
						<input type="text" id="id" name="id" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label id="nom"  class="col-sm-2 col-form-label">Nom:</label>
					<div class="col-sm-10">
						<input type="text" id="nom" name="nom" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label id="prenom"  class="col-sm-2 col-form-label">Preom:</label>
					<div class="col-sm-10">
						<input type="text" id="nom" name="prenom" class="form-control">
					</div>
				</div>
				
				<input type="submit" name="submit" value="Modifier" class="btn btn-primary">
			</form>
		</div>
		
		<div class="tab-pane container fade" id="supprimer" role="tabpanel">
			<h4 class="container mb-3 mt-3">Formulaire supprimer Etudiant</h4>

			<form action="dao2" method="post">
				<div class="form-group row">
					<label id="id" class="col-sm-2 col-form-label">Identifiant:</label>
					<div class="col-sm-10">
						<input type="text" id="id" name="id" class="form-control">
					</div>
				</div>
				
				<input type="submit" name="submit" value="Supprimer" class="btn btn-primary">
			</form>	
		</div>
		
		
		<!--  Affichage d'alerte du résultat de la suppression -->
		<div class="container mb-3 mt-3">
			<c:if test="${etudiantSupprime != null}" var="tester">
				<c:choose>
					<c:when test="${etudiantSupprime.id == 0}">
						<div class="alert alert-danger alert-dismissible fade show" role="alert">
							<c:out value="Impossible de supprimer cet étudiant. Voulez-vous vérifier que l'identifiant que vous aver entrez existe..."></c:out>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    	<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info alert-dismissible fade show" role="alert">
							<c:out value="L'étudiant(e) ${etudiantSupprime.nom} ${etudiantSupprime.prenom} est spprimmé(e)"></c:out>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    	<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
		
	</div>

	



	
	
	
	
	</div>

	<script>
		$('.tableetudiants').DataTable();
			  
	</script>
</body>
</html>