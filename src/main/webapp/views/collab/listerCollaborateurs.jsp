<%@page import="dev.sgp.util.Constantes"%>
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
	<h1>Les collaborateurs</h1>
	<div class="ml-2 card" style="width: 24rem">
        <%
            for (int i = 0; i < Constantes.COLLAB_SERVICE.listerCollaborateurs().size(); i++) {
                Collaborateur collab = Constantes.COLLAB_SERVICE.listerCollaborateurs().get(i);
        %>
        <h5 class="card-header"><%=collab.getNom()%> <%=collab.getPrenom()%></h5>
        <div class="card-body form-group col-sm-12">
                
          <img src="<%=collab.getPhoto()%>" class="img-fluid" alt="Responsive image">
          <div class="col">
            <p class="card-text">Date de naissance : <%=collab.getDateNaissance()%></p>
            <p class="card-text">Adresse : <%=collab.getAdresse()%></p>
            <p class="card-text">Email : <%=collab.getEmailPro()%></p>
            <p class="card-text">Numéro de sécurité sociale : <%=collab.getNumeroSecuriteSocial()%></p>      
          </div>
        </div>
        <div class="w-100"></div>
        <div align="right" class="mr-2">
 			<form action="<%=request.getContextPath()%>/collaborateurs/editer"
				method="get">
 			<input type="hidden" name="matricule" value="<%=collab.getMatricule()%>">
				<div class="form-group row justify-content-end">
					<button type="submit" class="btn btn-primary col-sm-2">Éditer</button>
				</div>
 			</form>
 
          
        </div>   
      
        <%
        }
        %>
        </div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
