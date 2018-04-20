<%@page import="java.time.LocalDate"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap/css/bootstrap.css"/>'>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">LOGO</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">Collaborateur
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Statistique</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Activités</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
	<% Collaborateur user = (Collaborateur)request.getAttribute("collab");
				
					if (user ==null){
						user = new Collaborateur("","",LocalDate.now(),"","");
					}
				
				%>
		<h1><%=user.getNom()%> <%=user.getPrenom()%> [Matricule: <%=user.getMatricule()%>]</h1>
		<div class="col-sm-5" >
		
		<img src="<%=user.getPhoto()%>" class="img-fluid" alt="Responsive image">
		</div>
		
		
		<div class="col-sm-12">
			<form action="<%=request.getContextPath()%>/collaborateurs/editer"
				method="post">
				
				
				<div class="form-group row">
					<label for="nom" class="col-sm-4">Nom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control form-control-sm" id="nom"
							name="nom" placeholder="Nom" value="<%=user.getNom()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="prenom" class="col-sm-4">Prenom</label>
					<div class="col-sm-8">
						<input type="text" class="form-control form-control-sm"
							id="prenom" name="prenom" placeholder="Prenom" value="<%=user.getPrenom()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="dateNaissance" class="col-sm-4">Date de
						naissance</label>
					<div class="col-sm-8">
						<input type="date" class="form-control form-control-sm"
							id="dateNaissance" name="dateNaissance" value="<%=user.getDateNaissance()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="Adresse" class="col-sm-4">Adresse</label>
					<div class="col-sm-8">
						<input type="text" class="form-control form-control-sm"
							id="adresse" name="adresse" placeholder="Adresse" value="<%=user.getAdresse()%>">
					</div>
				</div>
				<div class="form-group row">
					<label for="numSecuSocial" class="col-sm-4">Numéro de
						sécurité social</label>

					<div class="col-sm-8">
						<input type="text" class="form-control form-control-sm"
							id="numSecuSocial" name="numSecuSocial"
							placeholder="Numéro de sécurité social" maxlength="15" value="<%=user.getNumeroSecuriteSocial()%>">
					</div>
				</div>
				<div class="form-group row justify-content-end">
					<button type="submit" class="btn btn-primary col-sm-2">Créer</button>
				</div>

			</form>
		</div>
	</div>








	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
