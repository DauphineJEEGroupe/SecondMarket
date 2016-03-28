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
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Vendre un titre</h4>
					</div>
					<br>
					<p>
						<span class="message">${message}</span>
					</p>
					<form:form commandName="newtransaction" id="reg" class="form-horizontal">
						<p>
							Titre <Strong> ${newtransaction.titre.codeIsin}</Strong> de la
							société <Strong>${newtransaction.titre.societe.nom}</Strong>
						</p>
						<form:hidden path="vendeur.id" />
						<form:hidden path="titre.id" />
						<div class="form-group">
							
								<form:label path="quantite" class="control-label col-sm-4">Nombre de titre:</form:label>
								<div class="col-sm-6">
								<input type="number" class="form-control" name="quantite"
									id="quantite" required>
								<form:errors class="invalid" path="quantite" />
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
								<form:label path="prixOuverture" class="control-label col-sm-4">Prix initial unitaire:</form:label>
								<div class="col-sm-6">
								<input type="number" class="form-control" name="prixOuverture"
									id="prixOuverture" required>
								<form:errors class="invalid" path="prixOuverture" />
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
								<form:label path="prixCloture" class="control-label col-sm-4">Prix final unitaire:</form:label>
								<div class="col-sm-6">
								<input type="number" class="form-control" name="prixCloture"
									id="prixCloture" required>
								<form:errors class="invalid" path="prixCloture" />
								<p class="help-block"></p>
							</div>
						</div>

						<div class="form-group">
								<form:label path="modeNegociation.id" class="control-label col-sm-4">Mode de Négociation:</form:label>
								<div class="col-sm-6">
								<form:select path="modeNegociation.id" class="form-control">
									<form:option value="" label="Mode de Négociation" />
									<form:options items="${modeNegociations}" itemValue="id"
										itemLabel="code" required="required"/>
								</form:select>
								<p class="help-block"></p>
							</div>
						</div>
						<div class="form-group">
								<form:label path="dateCloture" class="control-label col-sm-4">Echéance:</form:label>
								<div class="col-sm-6">
								<form:input path="dateCloture"  required="required" placeholder="dd/mm/yyyy"/>
								<!-- 							<input type="date" class="form-control" name="dateCloture" id="dateCloture" required -->
								<!-- 								data-validation-required-message="Veuillez saisir une date"> -->
								<form:errors class="invalid" path="dateCloture" />
								<p class="help-block"></p>
							</div>
						</div>
						<input type="submit" value="Enregistrer" class="btn btn-default" />
						<!-- 					<button type="submit" class="btn btn-primary">vendre</button> -->
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
	<script>
		$(function() {
			$("#dateCloture").datepicker({
				dateFormat : 'dd/MM/yyyy'
			});
		});
	</script>
</body>

</html>
