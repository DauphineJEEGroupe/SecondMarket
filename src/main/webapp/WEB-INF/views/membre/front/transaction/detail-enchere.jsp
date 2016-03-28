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
					<li><a href="<c:url value="/transaction/achat"/>">Transactions</a></li>
					<li class="active">Détail</li>
				</ol>
			</div>
		</div>
        <!-- Marketing Icons Section -->
        		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
                   		<h4> Détail de la transaction - Mode ${transaction.modeNegociation.code} </h4>
            		</div>
							<div class="controls" style="margin-left: 5px;">
								<div class="row">
									<div class="col-md-4"><label class="control-label">Société : </label> <p>${transaction.titre.societe.nom}</p></div>
									<div class="col-md-4"><label class="control-label">quantite : </label> <p>${transaction.quantite}</div>
									<div class="col-md-4"><label class="control-label">titre : </label><p>${transaction.titre.codeIsin}</p></div>
								</div>
								<div class="row">
									<div class="col-md-4"><label class="control-label">dateDebut : </label><p>${transaction.dateDebut}</p></div>
									<div class="col-md-4"><label class="control-label">prix unitaire : </label><p>${transaction.prixCloture}</p></div>
									<div class="col-md-4"><label class="control-label">vendeur : </label><p>${transaction.vendeur.nom}</p></div>
								</div>
								<div class="row">
									<div class="col-md-4"><label class="control-label">dateCloture : </label><p>${transaction.dateCloture}</p></div>
									<div class="col-md-4"><label class="control-label">prix Transaction : </label><p>${transaction.prixTransaction}</p></div>
									<div class="col-md-4"><label class="control-label">acheteur : </label><p>${transaction.acheteur.nom}</p></div>
								</div>
								<form:form commandName="transaction" method="POST" class="form-inline" action="/transaction/achat">
									<form:hidden path="id" value="${transaction.id}" />
									<div class="form-group">
										<form:label path="prixCloture" class="control-label col-sm-8">Prix enchère unitaire:</form:label>
										<input type="number" class="form-control" name="prixCloture" id="prixCloture" required value="${transaction.prixCloture}">
									</div>
									<input type="submit" value="Acheter" class="btn btn-default" />
								</form:form>
							</div>
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
