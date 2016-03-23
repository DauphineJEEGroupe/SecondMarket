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

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Les Utilisateurs 
                    
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li class="active">Liste des utilisateurs</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">

            <!-- Blog Post Content Column -->
            <div class="col-lg-8">

                <!-- Blog Post -->

                <hr>

                <!-- Date/Time -->
                

           <div class="well">
                    <h4>Les demandes d'autorisation</h4>
                 
                      <TABLE BORDER WIDTH="80%">
	<TR>
		<TH>Nom Utilisateur</TH> <TH> Pr�nom</TH> <TH>Date de naissance</TH><TH>Email</TH><TH>Profession</TH><TH>T�l</TH><TH>Valider Investisseur</TH>
	</TR>
	<TR>
		<TD width=33%>A</TD> <TD width=33%>B</TD> <TD width=33%>C</TD><TD width=33%>C</TD><TD width=33%>A</TD><TD width=33%>A</TD><TD width=33%><a href="validerInvistisseur.html">Valider</a></TD>
	</TR>
	<TR>
		<TD>D</TD> <TD>E</TD> <TD>F</TD><TD>C</TD><TD>A</TD><TD>A</TD><TD><a href="validerInvistisseur.html">Valider</a></TD>
	</TR>
</TABLE>
                 
                    
                    <!-- /.row -->
                </div>

                <!-- Post Content -->
                  

                <!-- Blog Search Well -->
                <div class="well">
                    <h4>Blog Search</h4>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                    <!-- /.input-group -->
                </div>

                <!-- Blog Categories Well -->
                

                <!-- Side Widget Well -->
                

            

               

                <!-- Blog Comments -->

                <!-- Comments Form -->
             


                <!-- Posted Comments -->

                <!-- Comment -->
                

                <!-- Comment -->
              

            

            <!-- Blog Sidebar Widgets Column -->
          

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
