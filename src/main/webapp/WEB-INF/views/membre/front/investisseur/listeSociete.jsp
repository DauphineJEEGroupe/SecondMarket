<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Marché Secondaire | Paris-Dauphine</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="<c:url value="/static/resources/img/dauphin.jpg"/>"
	rel="shortcut icon">


<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/bootstrap.min.css"/>" />
<!-- Custom CSS -->
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<c:url value="/static/resources/css/screen.css"/>" /> --%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/modern-business.css"/>" />
<!-- Custom Fonts -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/font-awesome.min.css"/>" />
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/public/"/>">Marché
					Secondaire</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>

					<li><a href="<c:url value="/investisseur/Vente"/>">Créer
							offre </a></li>
					<li><a href="<c:url value="/investisseur/Titre/ajout"/>">Ajouter
							titre</a></li>
					<li><a href="<c:url value="/investisseur/transaction"/>">Mes
							Transactions</a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Achat/vente <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/investisseur"/>">Achat
									titres</a></li>
							<li><a href="<c:url value="/investisseur"/>">Vente titre</a>
							</li>
							<li><a href="<c:url value="/societe/list"/>">listes des
									sociétés</a></li>

						</ul></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Investisseur sociétés</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">sociétés</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<form:form commandName="societe" class="form-inline" action="/societe/search">
					<div class="form-group">
						<input type="hidden" id="siren" name="siren" value="siren">
						<input type="text" class="form-control" id="nom" name="nom"  minlength=3 placeholder="Société par nom ou siren (3 lettres min)">
					</div>
					<input type="submit" value="Rechercher" class="btn btn-default" />
<!-- 					<button type="submit" class="btn btn-default">Rechercher</button> -->
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Societes</h4>
					</div>
					<br>
					<c:choose>
						<c:when test="${societes.size()==0}">
							<p> <em>Aucune société de trouvée.</em></p>
						</c:when>
						<c:otherwise>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Nom</th>
										<th>Siren</th>
										<th>Ville</th>
										<th>Pays</th>
										<th>Statut</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${societes}" var="societe">
										<tr>
											<td>${societe.id}</td>
											<td>${societe.nom}</td>
											<td>${societe.siren}</td>
											<td>${societe.ville}</td>
											<td>${societe.pays}</td>
											<td>${societe.statut.code}</td>
											<td><a
												href="<c:url value="/societe/edit/${societe.id}"/>">Modifié</a></td>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->


	<spring:url value="/static/resources/js/jquery.js" var="jqueryJs" />
	<spring:url value="/static/resources/js/bootstrap.min.js"
		var="bootstrapMinJs" />



	<!-- jQuery -->
	<script src="${jqueryJs}"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${bootstrapMinJs}"></script>


</body>

</html>

</html>
