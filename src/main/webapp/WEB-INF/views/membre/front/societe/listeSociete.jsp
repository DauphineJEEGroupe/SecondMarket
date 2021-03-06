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
				<h1 class="page-header">Soci�t�s</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">soci�t�s</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<form:form commandName="societe" class="form-inline"
					action="/societe/search">
					<input type="hidden" id="siren" name="siren" value="siren">
					<div class="form-group">
     					 <label class="sr-only" for="nom">Rechercher:</label>
						<input type="text" class="form-control" id="nom" name="nom"
							minlength=3
							placeholder="(3 lettres min)">
					</div>
					<input type="submit" value="Rechercher" class="btn btn-default" />
					<div class="form-group">
				      <span class="help-block">Recherche d'une Soci�t� par son nom ou son Siren .</span>
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
								<h4>D�tail de la soci�t�:  ${societeDetail.nom}</h4>
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
												<a href="<c:url value="/transaction/societe/${societeDetail.id}"/>">Voir les titres en vente pour cette soci�t�</a>
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
					<h4>Liste des soci�t�s</h4>
				</div>
				<br>
				<c:choose>
					<c:when test="${societes.size()==0}">
						<p>
							<em>Aucune soci�t� de trouv�e.</em>
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
											<%-- 													<a href="<c:url value="/societe/edit/${societe.id}"/>">Modifi�</a> /  --%>
											<%-- 												</c:when> --%> <a
											href="<c:url value="/societe/detail/${societe.id}"/>">D�tail</a>
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
