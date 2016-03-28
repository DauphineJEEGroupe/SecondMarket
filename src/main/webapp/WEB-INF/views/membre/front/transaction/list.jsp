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
				<h1 class="page-header">Transaction</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">Transactions</li>
				</ol>
			</div>
		</div>
       <div class="row">
			<div class="col-md-6"></div>
			<div class="col-md-6">
				<form:form commandName="search" class="form-inline" action="/transaction/search">
					<div class="form-group">
     					 <label class="sr-only" for="titre.codeIsin">Rechercher:</label>
						<form:input path="titre.codeIsin" class="form-control" minlength="3" placeholder="(3 lettres min)"/>
					</div>
					<input type="submit" value="Rechercher" class="btn btn-default" />
					<div class="form-group">
				      <span class="help-block">Recherche d'une transaction par le code Isin du titre / nom de société.</span>
				    </div>
				</form:form>
			</div>
		</div>
        <div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
                   		<h4> Liste des Transactions </h4>
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
									<th>Vendeur</th>
									<th>Etat Transaction</th>
									<th>Mode Négociation </th>
									<th>Prix </th>
									<th>Date de cloture </th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${transactions}" var="transaction">
									<tr>
										<td>${transaction.titre.societe.nom}</td>
										<td>${transaction.vendeur.nom}</td>
										<td>${transaction.etatTransaction.code}</td>
										<td>${transaction.modeNegociation.code}</td>
										<td>${transaction.prixTransaction}</td>
										<td>${transaction.dateCloture}</td>
										<td><a href="<c:url value="/transaction/detail/${transaction.id}"/>">Détail</a></td>
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
