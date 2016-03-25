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
                <h1 class="page-header">Investisseur
                </h1>
                <ol class="breadcrumb">
                    <li><a href="AcceuilAdmin.jsp">accueil</a>
                    </li>
                    <li class="active">Valider investisseur</li>
                </ol>
            </div>
        </div>
        <!-- /.row --

        <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">

            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4> Informations Investisseur</h4>
                    </div>
                  <div class="controls" style="margin-left: 5px;">
                            <label class="control-label" >Nom : <c:out value="${ }"/></label>
                            </BR>
                            <label class="control-label">Prénom : <c:out value="${}"/></label></BR>
                            <label class="control-label">Date de naissance : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Email : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Profession : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Tél : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Adresse : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Liste des titres: <c:out value="${ }"/></label></BR>

                            <TABLE BORDER WIDTH="50%">
    <TR>
        <TH>Nom Titre</TH> <TH> Type</TH> <TH>Quantité</TH>
    </TR>
    <TR>
        <TD>A</TD> <TD>B</TD> <TD>C</TD>
    </TR>
    <TR>
        <TD>D</TD> <TD>E</TD> <TD>F</TD>
    </TR>
</TABLE>
                    </div>     
                </div>
            </div>
 <div class="col-md-4">
                    <a href="AcceuilAdmin.jsp" class="btn btn-primary">Valider</a>
                </div>
        </div>
        <!-- /.row -->

        <hr>
    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

</body>

</html>