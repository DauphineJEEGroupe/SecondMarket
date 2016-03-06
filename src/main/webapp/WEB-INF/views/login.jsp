<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Marché Secondaire | Paris-Dauphine</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css"
			href="<c:url value="/static/resources/css/screen.css"/>" />
	</head>

	<body>
		<div id="container">
			<div class="dualbrand">
				<img src="<c:url value="/static/resources/gfx/Dauphine_logo.png"/>" />
			</div>
			<div id="content">
				<h1>Identification</h1>
				<p>
					<span class="erreur">${erreur}</span>
				</p>
				<form:form commandName="userBean" id="reg">
					<table>
						<tbody>
							<tr>
								<td><form:label path="email">Adresse mail:</form:label></td>
								<td><form:input path="email"/></td> 
								<td><form:errors class="invalid" path="email"/></td>
							</tr>
							<tr>
								<td><form:label path="password">Mot de passe:</form:label></td>
								<td><form:password path="password" /></td> 
								<td><form:errors class="invalid" path="password"/></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Valider" class="register"/>
							</td>
						</tr>
					</table>
				</form:form>
				<div>
					<h3>Pas encore membre?</h3>
					<p>
					<a href="<c:url value="/"/>">Inscription investisseur</a><br />
			    	</p>
			</div>
			</div>
			
			<div id="footer">
			    <p>
					<a href="<c:url value="/"/>">Home</a><br />
			    </p>
			</div>
		</div>
	</body>
</html>
