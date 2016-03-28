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
				<h1 class="page-header">Investisseur titres</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">Profil investisseur</li>
				</ol>
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

    </div>
    <!-- /.container -->
    
    
	<spring:url value="/static/resources/js/jquery.js" var="jqueryJs" />
	<spring:url value="/static/resources/js/bootstrap.min.js" var="bootstrapMinJs" />



    <!-- jQuery -->
    <script src="${jqueryJs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${bootstrapMinJs}"></script>


</body>

</html>

</html>
