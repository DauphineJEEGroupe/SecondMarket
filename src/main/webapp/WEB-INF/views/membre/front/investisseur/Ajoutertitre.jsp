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


<!-- Bootstrap Core CSS -->
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
				<h1 class="page-header">Ajouter titre</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li><a href="<c:url value="/investisseur"/>">Profile
							investisseur</a></li>
					<li class="active">Ajouter titre</li>
				</ol>
			</div>
		</div>
		<div class="row">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Ajout d'un nouveau titre</h4>
					</div>
					<br>
					<p>
						<span class="message">${message}</span>
					</p>
					<form:form commandName="newTitre" id="reg">
						<table class="table">
							<tbody>
								<form:hidden path="proprietaire.id" />
								<tr>
									<td><form:label path="codeIsin">Code Isin:</form:label></td>
									<td><form:input path="codeIsin" /></td>
									<td><form:errors class="invalid" path="codeIsin" /></td>
								</tr>
								<tr>
									<td><form:label path="valeur">valeur:</form:label></td>
									<td><input type="number" class="form-control"
										name="valeur" id="valeur" required
										data-validation-required-message="Veuillez saisir un nombre"></td>
									<td><form:errors class="invalid" path="valeur" /></td>
								</tr>
								<tr>
									<td><form:label path="nbTitres">nbTitres:</form:label></td>
									<td><input type="number" class="form-control"
										name="nbTitres" id="nbTitres" required
										data-validation-required-message="Veuillez saisir un nombre"></td>
									<td><form:errors class="invalid" path="nbTitres" /></td>
								</tr>
								<tr>
									<td>Type Contrat :</td>
									<td><form:select path="typeContrat.id">
											<form:option value="NONE" label="--- Select ---" />
											<form:options items="${typeContrats}" itemValue="id"
												itemLabel="code" />
										</form:select></td>
								</tr>
								<tr>
									<td>Societe :</td>
									<td><form:select path="societe.id">
											<form:option value="NONE" label="--Please Select" />
											<form:options items="${societes}" itemValue="id"
												itemLabel="nom" />
										</form:select></td>
								</tr>
							</tbody>
						</table>
						<table  class="table">
							<tr>
								<td><input type="submit" value="Enregistrer"
									class="register" /></td>
							</tr>
						</table>
					</form:form>

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
