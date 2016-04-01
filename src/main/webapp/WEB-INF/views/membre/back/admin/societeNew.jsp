<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<jsp:include page="../../fragments/header.jsp"/>

<body>

	<!-- Navigation -->
<jsp:include page="../../fragments/includeNavAdmin.jsp"/>


    <!-- Page Content -->
    <div class="container">
    		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sociétés</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li><a href="<c:url value="/admin"/>">Administration</a></li>
					<li><a href="<c:url value="/admin/societe"/>">Sociétés</a></li>
					<li class="active">Nouvelle Société</li>
				</ol>
			</div>
		</div>
				<div class="row">
				<div class="col-md-12">
					<div class="row">
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>Détail de la société:  ${societeDetail.nom} </h4>
							</div>
							<br>
							<form:form commandName="societe" id="reg">
								<div class="form-group">
								    <form:label path="nom">Nom:</form:label>
								    <form:input path="nom" class="form-control" required="required"/>
								</div>
								<div class="form-group">
								    <form:label path="siren">Siren:</form:label>
								    <form:input path="siren" class="form-control" required="required"/>
								</div>
								<div class="form-group">
								    <form:label path="ville">Ville:</form:label>
								    <form:input path="ville" class="form-control" required="required"/>
								</div>
								<div class="form-group">
								    <form:label path="pays">Pays:</form:label>
								    <form:input path="pays" class="form-control" required="required"/>
								</div>
								<input type="submit" value="Enregistrer" class="btn btn-default" />
							</form:form>
						</div>
					</div>
					<div class="col-md-6"></div>
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
