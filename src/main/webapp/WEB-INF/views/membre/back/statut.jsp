<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Marché Secondaire</title>
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
				<h1>Statuts d'une société</h1>

				<form:form commandName="newStatut" id="reg">
					<h2>Nouveau statut</h2>
					<table>
						<tbody>
							<tr>
								<td><form:label path="code">Code:</form:label></td>
								<td><form:input path="code"/></td>
								<td><form:errors class="invalid" path="code"/></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Enregistrer" class="register"/>
							</td>
						</tr>
					</table>
				</form:form>
				<h2>Statuts</h2>
				<c:choose>
					<c:when test="${statuts.size()==0}">
						<em>No registered statuts.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>Code</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${statuts}" var="statut">
									<tr>
										<td>${statut.id}</td>
										<td>${statut.code}</td>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="footer">
			    <p>
					<a href="<c:url value="/public/"/>">Home</a> | <a href="<c:url value="/statut"/>">Statut</a> | <a href="<c:url value="/societe"/>">Societe</a><br />
			    </p>
			</div>
		</div>
	</body>
</html>
