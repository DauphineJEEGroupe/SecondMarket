<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>March� Secondaire | Paris-Dauphine</title>
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
                <a class="navbar-brand" href="<c:url value="/public/"/>">March� Secondaire</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
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
                <a class="navbar-brand" href="index.html">Nom de site( a proposer)</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="acceuil.jsp">accueil</a>
                    </li>
                    <li>
                        <a href="AccréditationSociété.html">Accréditer Société</a>
                    </li>
                     <li>
                        <a href="ListeUtilisateur.html">Autoriser utilisateur</a>
                    </li>
                   <li>
                        <a href="profilAdminRecherche.html">Rechercher</a>
                    </li>
                    <li>
                        <a href="about.html"> Se deconnecter</a>
                    </li>
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Profil administrateur
                </h1>
                <ol class="breadcrumb">
                    <li><a href="acceuil.jsp">Acceuil</a>
                    </li>
                    <li class="active">profil admin</li>
                    <li class="active">Recherche</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
 
 
        

        <!-- Service Tabs -->
        
            <div class="col-lg-4 ">

                
        

            </div>
       
            <div class="col-md-12">

                <div class="panel panel-default">

                    <div class="panel-heading">

                        <h4><i class="fa fa-fw fa-check"></i> Recherche d'informations</h4>
                    </div>
                    <div class="panel-body">



<div class="col-md-3">
                <div class="list-group">
                    <a href="ListeSociétés.html" class="list-group-item">Recherche Société</a>
                    <a href="ListeUtilisateur.html" class="list-group-item">Recherche Utilisateur</a>
                    <a href="ListeInvestisseurs.html" class="list-group-item">Recherche Investisseur</a>
                    
                    <li class="dropdown">
                        <a href="#" class="list-group-item" data-toggle="dropdown">Recherche Des Offres <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="OffresAchat.html">Achat Contrat</a>
                            </li>
                            <li>
                                <a href="OffresVente.html">Vente Contrat</a>
                            </li>
                           
                            
                        </ul>
                    </li>


                     <li class="dropdown">
                        <a href="#" class="list-group-item" data-toggle="dropdown">Recherche Transactions <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                        <li>
                                <a href="listeTransactions.html">Les transaction effectuées</a>
                            </li>
                                                    
                           
                        </ul>
                    </li>
                    
                </div>
            </div>











                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        
                    </div>
                </div>
            </div>


















        <!-- Service List -->
        <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
        
 
    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
