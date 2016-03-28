	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/accueil/"/>">Marché
					Secondaire</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li> <a href="<c:url value="/public/login"/>">Mon compte</a></li>
					<li><a href="<c:url value="/investisseur/Titre/ajout"/>">Ajouter
							titre</a></li>
					<li><a href="<c:url value=""/>"></a></li>
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Transactions <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/transaction/achat"/>">Toutes les transactions</a></li>
							<li><a href="<c:url value="/transaction/list"/>">Mes transactions</a> </li>

						</ul>
					</li>
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Achat/vente <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/transaction/achat"/>">Achat
									titres</a></li>
							<li><a href="<c:url value="/investisseur"/>">Vente titre</a>
							</li>
							<li><a href="<c:url value="/societe/list"/>">listes des
									sociétés</a></li>

						</ul>
					</li>
					<li> <a href="<c:url value="/public/logout"/>">Déconnexion</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>