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
					<li class="active">Sociétés</li>
				</ol>
			</div>
		</div>
		${message}
		${erreur}
		<div class="row">
			<div class="col-md-6"><a href="<c:url value="/admin/societe/new"/>" class="btn btn-info" role="button">Nouvelle société</a></div>
			<div class="col-md-6">
				<form:form commandName="societe" class="form-inline"
					action="/admin/societe/search">
					<input type="hidden" id="siren" name="siren" value="siren">
					<div class="checkbox">
					  <label><form:checkbox path="statut.code" value="REFERENCEE"/> A accréditer</label>
					</div>
					<div class="form-group">
     					 <label class="sr-only" for="nom">Rechercher:</label>
						<input type="text" class="form-control" id="nom" name="nom"
							minlength=3
							placeholder="(3 lettres min)">
					</div>
					<input type="submit" value="Rechercher" class="btn btn-default" />
					<div class="form-group">
				      <span class="help-block">Recherche d'une Société par son nom ou son Siren .</span>
				    </div>
				</form:form>
			</div>
		</div>
		<c:choose>
			<c:when test="${null==societeDetail}">
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>Détail de la société <strong> ${societeDetail.nom}</strong> </h4>
							</div>
							<br>
							<table class="table table-striped">
								<tbody>
										<tr>
											<td><strong>Siren</strong> </td><td>${societeDetail.siren}</td>
										</tr><tr>
											<td><strong>Adresse</strong> </td><td>${societeDetail.ville} - ${societeDetail.pays}</td>
										</tr><tr>
										
											<td>
											<c:if test="${null==societeDetail.representant}">
												<a href="<c:url value="/admin/societe/accrediter/${societeDetail.id}"/>" class="btn btn-info" role="button">Accréditer cette société</a>
											</c:if>
											<c:if test="${null!=societeDetail.representant}">
												<td><strong>Representant: </strong> </td><td>${societeDetail.representant.nom}</td>
											</c:if>
											</td>
										
											<td>
											</td>
										</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>Liste des sociétés</h4>
				</div>
				<br>
				<c:choose>
					<c:when test="${societes.size()==0}">
						<p>
							<em>Aucune société de trouvée.</em>
						</p>
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
										<td>
											<%-- 												<c:when test="${sessionScope.userBean.isConneted}"> --%>
											<%-- 													<a href="<c:url value="/societe/edit/${societe.id}"/>">Modifié</a> /  --%>
											<%-- 												</c:when> --%> <a
											href="<c:url value="/admin/societe/detail/${societe.id}"/>">Détail</a>
										</td>
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
