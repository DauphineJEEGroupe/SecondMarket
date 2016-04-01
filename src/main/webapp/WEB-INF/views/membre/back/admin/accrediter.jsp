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
					<li class="active">Accréditation</li>
				</ol>
			</div>
		</div>
				<div class="row">
				<div class="col-md-12">
					<div class="row">
					<div class="col-md-6">
<!-- 						<div class="panel panel-default"> -->
							<div class="panel-heading">
								<h4>Representant de la société:  ${societe.nom} </h4> 
							</div>
							<br>
<%-- 							<c:if test="${!empty erreur}"> : ${erreur}</c:if> --%>
							${message}
							${erreur}
							<form:form commandName="representant" id="reg" action="/admin/societe/accrediter">
								<form:hidden path="societe.id" value="${societe.id}"/>
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
<!-- 						</div> -->
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
