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
					<li><a href="<c:url value="/investisseur/Titre/ajout"/>">Ajouter
							titre</a></li>
					<li><a href="<c:url value="/transaction/list"/>">Mes
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
				<h1 class="page-header">Vente de titre</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li><a href="<c:url value="/investisseur"/>">Profile
							investisseur</a></li>
					<li class="active">Vendre un titre</li>
				</ol>
			</div>
		</div>
		<!-- /.row --

        <!-- Contact Form -->
		<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
		<div class="row">
<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Vendre un titre</h4>
					</div>
					<br>
					<p>
						<span class="message">${message}</span>
					</p>
					<form:form commandName="newtransaction" id="reg">
						<p>
							Titre <Strong> ${newtransaction.titre.codeIsin}</Strong> de la
							société <Strong>${newtransaction.titre.societe.nom}</Strong>
						</p>
						<form:hidden path="vendeur.id" />
						<form:hidden path="titre.id" />
						<div class="control-group form-group">
							<div class="controls">
								<form:label path="quantite">Nombre de titre:</form:label>
								<input type="number" class="form-control" name="quantite"
									id="quantite" required>
								<form:errors class="invalid" path="quantite" />
								<p class="help-block"></p>
							</div>
						</div>
						<div class="control-group form-group">
							<div class="controls">
								<form:label path="prixOuverture">Prix initial unitaire:</form:label>
								<input type="number" class="form-control" name="prixOuverture"
									id="prixOuverture" required>
								<form:errors class="invalid" path="prixOuverture" />
								<p class="help-block"></p>
							</div>
						</div>
						<div class="control-group form-group">
							<div class="controls">
								<form:label path="prixCloture">Prix final unitaire:</form:label>
								<input type="number" class="form-control" name="prixCloture"
									id="prixCloture" required>
								<form:errors class="invalid" path="prixCloture" />
								<p class="help-block"></p>
							</div>
						</div>

						<div class="control-group form-group">
							<div class="controls">

								<form:select path="modeNegociation.id">
									<form:option value="NONE" label="Mode de Négociation" />
									<form:options items="${modeNegociations}" itemValue="id"
										itemLabel="code" />
								</form:select>
								<p class="help-block"></p>
							</div>
						</div>
						<div class="control-group form-group">
							<div class="controls">
								<form:label path="dateCloture">Echéance:</form:label>
								<form:input path="dateCloture" />
								<!-- 							<input type="date" class="form-control" name="dateCloture" id="dateCloture" required -->
								<!-- 								data-validation-required-message="Veuillez saisir une date"> -->
								<form:errors class="invalid" path="dateCloture" />
								<p class="help-block"></p>
							</div>
						</div>
						<input type="submit" value="Enregistrer" class="register" />
						<!-- 					<button type="submit" class="btn btn-primary">vendre</button> -->
					</form:form>
				</div>
			</div>
			<div class="col-md-3"></div>
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
	<script>
		$(function() {
			$("#dateCloture").datepicker({
				dateFormat : 'dd/MM/yyyy'
			});
		});
	</script>
</body>

</html>
