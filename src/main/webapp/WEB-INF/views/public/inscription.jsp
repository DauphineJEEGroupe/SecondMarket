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
				<a class="navbar-brand" href="<c:url value="/"/>">Marché
					Secondaire</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/"/>">accueil</a></li>
					<li><a href="<c:url value="/public/login"/>">Mon compte</a></li>


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
				<h1 class="page-header">Inscription Investisseur</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/"/>">accueil</a></li>
					<li class="active">Inscription</li>
				</ol>
			</div>
		</div>

		<div class="row">
			<div class="col-md-5">
			<h4>Ajout d'un nouvel utilisateur</h4>
				<form:form commandName="newInvestisseur" id="reg">
					<p class="${empty form.erreurs ? 'has-success' : 'has-error'}">${form.resultat}</p>
					<div class="form-group">
						<form:label path="nom">Nom:</form:label>
						<form:input path="nom" class="form-control"  required="required"/>
						<form:errors class="invalid" path="nom" />
					</div>
					<div class="form-group">
						<form:label path="prenom">Prénom:</form:label>
						<form:input path="prenom" class="form-control" />
						<form:errors class="invalid" path="prenom" />
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:input path="email" class="form-control"  required="required"/>
						<form:errors class="invalid" path="email" />
					</div>
					<div class="form-group">
						<form:label path="phoneNumber">Téléphone:</form:label>
						<form:input path="phoneNumber" class="form-control" />
						<form:errors class="invalid" path="phoneNumber" />
					</div>
					<div class="form-group">
						<form:label path="pass">Mot de passe:</form:label>
						<form:password path="pass" required="required"
							class="form-control" />
						<form:errors class="invalid" path="pass" />
						<p class="help-block"></p>
					</div>
					<div class="form-group">
						<form:label path="pass2">Mot de passe:</form:label>
						<form:password path="pass2" required="required"
							class="form-control" />
						<form:errors class="invalid" path="pass2" />
						<p class="help-block"></p>
					</div>
					<input type="submit" value="Enregistrer" class="btn btn-default" />
				</form:form>
			</div>

		</div>
		<!-- /.row -->

		<hr>

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
