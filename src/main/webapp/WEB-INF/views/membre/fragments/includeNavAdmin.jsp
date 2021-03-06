    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
                    <li> <a href="<c:url value="/public/login"/>">Mon compte <c:if test="${!empty sessionScope.userBean}"> : ${sessionScope.userBean.username}</c:if></a></li>
                    <li>
                        <a href="<c:url value="/admin/societe"/>">Gestion Soci�t�</a>
                    </li>
                    <li>
                        <a href="<c:url value="/admin/utilisateur"/>">Gestion utilisateur</a>
                    </li>
                     <li>
                        <a href="<c:url value="/admin/search"/>">Rechercher</a>
                    </li>
                   <li> <a href="<c:url value="/public/logout"/>">D�connexion</a></li>
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>