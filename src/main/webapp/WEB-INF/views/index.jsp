<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Marché Secondaire | Paris-Dauphine</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/screen.css"/>"/>
	</head>

	<body>
		<div id="container">
			<div class="dualbrand">
				<img src="<c:url value="/static/resources/gfx/Dauphine_logo.png"/>"/>
			</div>
			<div id="content">
				<h1>Bienvenue sur Dauphine Second Market!</h1>

				<div>
					<p>Cette application web est basée sur le framework Spring MVC .</p>
					<h3>Elle tourne sur:</h3>
					<img src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>"/>
				</div>

			</div>
			<div id="aside">
				<p>Acces rapide.</p>
				<ul>
					<li><a href="<c:url value="/public/login"/>">Connexion</a></li>
					<li><a href="<c:url value="/user/inscription"/>">Inscription</a></li>
					<li><a href="<c:url value="/statut"/>">Statut</a></li>
					<li><a href="<c:url value="/societe"/>">Societe</a></li>
				</ul>
			</div>
			<div id="footer">
			    <p>
					Project Marché Secondaire | Paris-Dauphine<br />
			    </p>
			</div>
		</div>
	</body>
</html>
