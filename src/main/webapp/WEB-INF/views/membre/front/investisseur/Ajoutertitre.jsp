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
