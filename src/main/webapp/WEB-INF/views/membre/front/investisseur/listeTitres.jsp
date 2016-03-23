<!DOCTYPE html>
<html lang="en">

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
                        <a href="about.html">accueil</a>
                    </li>
                    <li>
                        <a href="listeTitres.html">Creer Offre</a>
                    </li>
                     <li>
                        <a href="Ajoutertitre.html">Ajouter titre</a>
                    </li>
                     <li>
                        <a href="s.html">Mes Transactions</a>
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
                <h1 class="page-header">Blog Home One
                    <small>Subheading</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li class="active">Blog Home One</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <div class="row">

            <!-- Blog Entries Column -->
            <div class="col-md-8">

                <!-- First Blog Post -->
                <h2>
                    <a href="#">Nom du titre</a>
                </h2>
               
           
                
                <div class="controls" style="margin-left: 5px;">
                            <label class="control-label" >Nom titre : <c:out value="${ }"/></label>
                            </BR>
                            <label class="control-label">Type titre : <c:out value="${}"/></label></BR>
                            <label class="control-label">Quantité titre : <c:out value="${ }"/></label></BR>
                            <label class="control-label">Prix sur le marché : <c:out value="${ }"/></label></BR>

                    </div> 
                <a class="btn btn-primary" href="vendretitre.html">Vendre ce titre <i class="fa fa-angle-right"></i></a>

                <hr>

                <!-- Second Blog Post -->
                 <h2>
                    <a href="#">Nom du titre</a>
                </h2>
               
                
                
              <div class="controls" style="margin-left: 5px;">
                            <label class="control-label" >Nom titre : <c:out value="${ }"/></label>
                            </BR>
                            <label class="control-label">Type titre : <c:out value="${}"/></label></BR>
                            <label class="control-label">Quantité titre : <c:out value="${ }"/></label></BR>
                              <label class="control-label">Prix sur le marché : <c:out value="${ }"/></label></BR>
                    </div> 
                <a class="btn btn-primary" href="vendretitre.html">Vendre ce titre <i class="fa fa-angle-right"></i></a>

                <hr>

                <!-- Third Blog Post -->
                <h2>
                    <a href="#">Nom du titre</a>
                </h2>
                
                
                
                  <div class="row">

            
                    
                  <div class="controls" style="margin-left: 5px;">
                            <label class="control-label" >Nom titre : <c:out value="${ }"/></label>
                            </BR>
                            <label class="control-label">Type titre : <c:out value="${}"/></label></BR>
                            <label class="control-label">Quantité titre : <c:out value="${ }"/></label></BR>
                               <label class="control-label">Prix sur le marché : <c:out value="${ }"/></label></BR>
                    </div>     
             
        </div>
                <a class="btn btn-primary" href="vendretitre.html">Vendre ce titre <i class="fa fa-angle-right"></i></a>

                <hr>

                <!-- Pager -->
                <ul class="pager">
                    <li class="previous">
                        <a href="#">&larr; Older</a>
                    </li>
                    <li class="next">
                        <a href="#">Newer &rarr;</a>
                    </li>
                </ul>

            </div>

            <!-- Blog Sidebar Widgets Column -->
            <div class="col-md-4">

                <!-- Blog Search Well -->
                <div class="well">
                    <h4>Recherche de titre</h4>
                    <div class="input-group">
                        <input type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                    <!-- /.input-group -->
                </div>

                <!-- Blog Categories Well -->
                <div class="well">
                    <h4>Blog Categories</h4>
                    <div class="row">
                        <div class="col-lg-6">
                            <ul class="list-unstyled">
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                            </ul>
                        </div>
                        <!-- /.col-lg-6 -->
                        <div class="col-lg-6">
                            <ul class="list-unstyled">
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                                <li><a href="#">Category Name</a>
                                </li>
                            </ul>
                        </div>
                        <!-- /.col-lg-6 -->
                    </div>
                    <!-- /.row -->
                </div>

                <!-- Side Widget Well -->
                <div class="well">
                    <h4>Side Widget Well</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
                </div>

            </div>

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
