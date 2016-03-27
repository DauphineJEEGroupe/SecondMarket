<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>March� Secondaire | Paris-Dauphine</title>
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
				<a class="navbar-brand" href="<c:url value="/public/"/>">March�
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
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Achat/vente <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/transaction/achat"/>">Achat
									titres</a></li>
							<li><a href="<c:url value="/investisseur"/>">Vente titre</a>
							</li>
							<li><a href="<c:url value="/societe/list"/>">listes des
									soci�t�s</a></li>

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
				<h1 class="page-header">Profil investisseur</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">Profil investisseur</li>
				</ol>
			</div>
		</div>
		<!-- /.row --

        <!-- Contact Form -->
		<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
		<div class="row">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Informations Investisseur</h4>
					</div>
					<div class="controls" style="margin-left: 5px;">
						<label class="control-label">Nom : ${investisseur.nom}</label> <br>
						<label class="control-label">Pr�nom :
							${investisseur.prenom}</label> <br> <label class="control-label">Email
							: ${investisseur.email}</label><br> <label class="control-label">T�l
							: ${investisseur.phoneNumber}</label> <br>
					</div>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Liste de mes titres</h4>
					</div>
					<br>
					<c:choose>
						<c:when test="${titres.size()==0}">
							<em>No registered titres.</em>
						</c:when>
						<c:otherwise>
							<table class="table">
								<thead>
									<tr>
										<th>codeIsin</th>
										<th>societe</th>
										<th>typeContrat</th>
										<th>valeur</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${titres}" var="titre">
										<tr>
											<td>${titre.codeIsin}</td>
											<td>${titre.societe.nom}</td>
											<td>${titre.typeContrat.code}</td>
											<td>${titre.valeur}</td>
											<td><a
												href="<c:url value="/transaction/vendre/${titre.id}"/>">Vendre</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Liste de mes Transactions</h4>
					</div>

					<c:choose>
						<c:when test="${transactions.size()==0}">
							<em>No registered transactions.</em>
						</c:when>
						<c:otherwise>
							<table class="table">
								<thead>
									<tr>
										<th>Soci�t�</th>
										<th>Type Transaction</th>
										<th>Etat Transaction</th>
										<th>Mode N�gociation</th>
										<th>Prix</th>
										<th>Date de cloture </th>
										<th>Acheteur</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${transactions}" var="transaction">
										<tr>
											<td>${transaction.titre.societe.nom}</td>
											<td>${transaction.typeTransaction.code}</td>
											<td>${transaction.etatTransaction.code}</td>
											<td>${transaction.modeNegociation.code}</td>
											<td>${transaction.prixCloture}</td>
											<td>${transaction.dateCloture}</td>
											<td>${transaction.acheteur.nom}</td>
											<td><a
												href="<c:url value="/transaction/detail/${transaction.id}"/>">D�tail</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

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
