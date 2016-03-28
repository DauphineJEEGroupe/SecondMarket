<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<jsp:include page="fragments/header.jsp"/>

<body>

	<!-- Navigation -->
<jsp:include page="fragments/includeNav.jsp"/>

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
                <div class="fill" style="background-image:url('<c:url value="/static/resources/img/bourse1.jpg"/>');"></div>
                <div class="carousel-caption">
<!--                     <h2>Caption 1</h2> -->
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('<c:url value="/static/resources/img/bourse2.jpg"/>');"></div>
                <div class="carousel-caption">
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('<c:url value="/static/resources/img/bourse3.jpg"/>');"></div>
                <div class="carousel-caption">
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
                    Acceuil
                </h1>
            </div>
             
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> UE Serveurs d'Application, Université Paris-Dauphine 2015-2016</h4>
                    </div>
                    <div class="panel-body">
                        <p>Ce site internet est le travail du projet demandé pour l'UE Serveurs d'Application.
                        Ce travail a été réalisé par le groupe suivant : Barou René, Maghrad Badr, Goupil Aymeric, Tebib Oualid</p>
                        
                    </div>
                </div>
            </div>
          
        </div>
        <!-- /.row -->

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
