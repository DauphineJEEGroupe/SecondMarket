<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<h1>Page des sociétés</h1>


			<form:form id="reg" method="POST" commandName="societeToUpdate" action="${pageContext.request.contextPath}/societe/edit/${societeToUpdate.id}.html">
				<h2>Modifier une société</h2>
				<table>
					<tbody>
						<tr>
							<td><form:label path="nom">Nom:</form:label></td>
							<td><form:input path="nom" /></td>
							<td><form:errors class="invalid" path="nom" /></td>
						</tr>
						<tr>
							<td><form:label path="siren">Siren:</form:label></td>
							<td><form:input path="siren" /></td>
							<td><form:errors class="invalid" path="siren" /></td>
						</tr>
						<tr>
							<td><form:label path="ville">Ville:</form:label></td>
							<td><form:input path="ville" /></td>
							<td><form:errors class="invalid" path="ville" /></td>
						</tr>
						<tr>
							<td><form:label path="pays">Pays:</form:label></td>
							<td><form:input path="pays" /></td>
							<td><form:errors class="invalid" path="pays" /></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tr>
						
						<td><input type="submit" value="Enregistrer" class="register" /></td>
						<td><input type="reset" value="Annuler" class="register" /></td>
					</tr>
					<tr>
						<td><form:button><a href="<c:url value="/societe/accredit/${societeToUpdate.id}"/>">Accrediter</a></form:button></td>
						<td><form:button><a href="<c:url value="/societe/delete/${societeToUpdate.id}"/>">Supprimer</a></form:button></td>
					</tr>
					
				</table>
			</form:form>
		</div>
		<div id="footer">
			<p>
				<a href="<c:url value="/"/>">Home</a> | <a href="<c:url value="/statut"/>">Statut</a> | <a href="<c:url value="/societe"/>">Societe</a><br />
			</p>
		</div>
	</div>
</body>
</html>
