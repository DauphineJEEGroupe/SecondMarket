<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<jsp:include page="../../fragments/header.jsp"/>

<body>

	<!-- Navigation -->
<jsp:include page="../../fragments/includeNav.jsp"/>

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
						<div class="row">
							
							<div class="col-md-3"><label class="control-label">Nom :  </label> <p>${investisseur.nom}</p></div>
							<div class="col-md-3"><label class="control-label">Prénom :  </label> <p>${investisseur.prenom}</p></div>
							<div class="col-md-6"></div>
						</div>
						<div class="row">
							<div class="col-md-3"><label class="control-label">Email : </label> <p> ${investisseur.email}</p></div>
							<div class="col-md-3"><label class="control-label">Tél: </label> <p> ${investisseur.phoneNumber}</p></div>
							<div class="col-md-6"></div>
						</div>
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
										<th>valeur unitaire</th>
										<th>Quantité</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${titres}" var="titre">
										<tr>
											<td>${titre.codeIsin}</td>
											<td><a href="<c:url value="/transaction/societe/${titre.societe.id}"/>">${titre.societe.nom}</a> </td>
											<td>${titre.typeContrat.code}</td>
											<td>${titre.valeur}</td>
											<td>${titre.nbTitres}</td>
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
										<th>Société</th>
										<th>Type Transaction</th>
										<th>Etat Transaction</th>
										<th>Mode Négociation</th>
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
												href="<c:url value="/transaction/detail/${transaction.id}"/>">Détail</a></td>
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
