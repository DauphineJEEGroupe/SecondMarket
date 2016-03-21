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

        <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide One');"></div>
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Accueil investisseur - ${sessionScope.userBean.username}
                </h1>
            </div>
             
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> Informations sur le site</h4>
                    </div>
                    <div class="panel-body">
                        <p>Cette application web est basée sur le framework Spring MVC .</p>
                        
                    </div>
                </div>
            </div>
          
        </div>
        <!-- /.row -->

        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Acces rapide.</h2>
            </div>
            <div class="col-md-6">
                <p>Cliquer sur un lien pour acceder à la page:</p>
                <ul>
                    <li><strong><a href="<c:url value="/investisseur/profil"/>">Mon profil investisseur</a></strong>
                    </li>
                    <li><a href="<c:url value="/investisseur/Vente"/>">Créer une offre de vente</a></li>
                </ul>
                
            </div>
            <div class="col-md-6">
            	<h2 class="page-header">Liste de mes titres</h2>
            </div>
        </div>

   <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
                </div>
            </div>
        </div>

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

</html>
