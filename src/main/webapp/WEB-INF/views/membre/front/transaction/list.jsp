<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<title>Marché Secondaire | Paris-Dauphine</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="<c:url value="/static/resources/img/dauphin.jpg"/>" rel="shortcut icon">


<!-- Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/bootstrap.min.css"/>" />
<!-- Custom CSS -->
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<c:url value="/static/resources/css/screen.css"/>" /> --%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/modern-business.css"/>" />
<!-- Custom Fonts -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/font-awesome.min.css"/>" />
</head>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/public/"/>">Marché Secondaire</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="<c:url value="/public/login"/>">Mon compte</a>
                    </li>
                    <li>
                        <a href="<c:url value="/user/inscription"/>">Inscription</a>
                    </li>
                    <li class="dropdown">
                        <a href="" class="dropdown-toggle" data-toggle="dropdown">Achat/vente <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="<c:url value="/investisseur"/>">Achat titres</a>
                            </li>
                            <li>
                                <a href="<c:url value="/investisseur"/>">Vente titre</a>
                            </li>
                            <li>
                                <a href="<c:url value="/investisseur"/>">listes des sociétés</a>
                            </li>
                           
                        </ul>
                    </li>
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Liste des Transactions - ${sessionScope.userBean.username}
                </h1>
            </div>
             
            <div class="col-md-12">
                <c:choose>
					<c:when test="${transactions.size()==0}">
						<em>No registered transactions.</em>
					</c:when>
					<c:otherwise>
						<table class="bootstrap-table">
							<thead>
								<tr>
									<th>Société</th>
									<th>Type Transaction</th>
									<th>Etat Transaction</th>
									<th>Mode Négociation </th>
									<th>Prix </th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${transactions}" var="transaction">
									<tr>
										<td>${transaction.titre.societe.nom}</td>
										<td>${transaction.typeTransaction.code}</td>
										<td>${transaction.etatTransaction.code}</td>
										<td>${transaction.modeNegociation.code}</td>
										<td>${transaction.prixCloture}</td>
										<td><a href="<c:url value="/transaction/detail/${transaction.id}"/>">Détail</a></td>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
            </div>
          
        </div>
        <!-- /.row -->

        <hr>

    </div>
    <!-- /.container -->
    
    
	<spring:url value="/static/resources/js/jquery.js" var="jqueryJs" />
	<spring:url value="/static/resources/js/bootstrap.min.js" var="bootstrapMinJs" />



    <!-- jQuery -->
    <script src="${jqueryJs}"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${bootstrapMinJs}"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
