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
				<h1 class="page-header">Administration du site</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/public/"/>">accueil</a></li>
					<li class="active">Administration</li>
				</ol>
			</div>
		</div>
		<div class="row">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>Accès rapide</h4>
					</div>
					<br>
					<p>
						<span class="message">${message}</span>
					</p>
					
				</div>
			</div>
		</div>
	
					

    </div>
    <spring:url value="/static/resources/js/jquery.js" var="jqueryJs" />
			<spring:url value="/static/resources/js/bootstrap.min.js"
				var="bootstrapMinJs" />



			<!-- jQuery -->
			<script src="${jqueryJs}"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="${bootstrapMinJs}"></script>
</body>

</html>

