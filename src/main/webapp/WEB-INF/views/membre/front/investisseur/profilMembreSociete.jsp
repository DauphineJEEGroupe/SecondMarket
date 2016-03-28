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
                <h1 class="page-header"> Administrateur
                </h1>
                <ol class="breadcrumb">
                    <li><a href="">accueil</a>
                    </li>
                    <li class="active">Accréditer société</li>
                     <li class="active">Membre société</li>
                </ol>
            </div>
        </div>
        <!-- /.row --

        <!-- Contact Form -->
        <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
        <div class="row">

            <div class="col-md-5">
            <h4> Création du membre société</h4>
                <form name="sentMessage" id="contactForm" novalidate>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Nom:</label>
                            <input type="text" class="form-control" id="nom" required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Prénom:</label>
                            <input type="text" class="form-control" id="prenom" required data-validation-required-message="Please enter your prenom.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Email:</label>
                            <input type="email" class="form-control" id="email" required data-validation-required-message="Please enter your email address.">
                        </div>
                    </div>
                       <div class="control-group form-group">
                        <div class="controls">
                            <label>Pseudo:</label>
                            <input type="password" class="form-control" id="pass" required data-validation-required-message="Please enter your password.">
                        </div>
                    </div>
                      <div class="control-group form-group">
                        <div class="controls">
                            <label>mot de passe:</label>
                            <input type="password" class="form-control" id="pass" required data-validation-required-message="Please enter your password.">
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">Valider</button>
                </form>
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

</body>

</html>
