<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<h1>Page des sociétés</h1>
	
				<p>
					<span class="message">${message}</span>
				</p>
				<c:if test=" ${null != sessionScope['scopedTarget.userBean'] }">
					<p>${sessionScope['scopedTarget.userBean'].username}</p>
				</c:if>
				<form:form commandName="newSociete" id="reg">
					<h2>Ajout d'une nouvelle une société</h2>
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
							<td><input type="submit" value="Enregistrer" class="register" />
							</td>
						</tr>
					</table>
				</form:form>
				<h2>Societes</h2>
				<c:choose>
					<c:when test="${societes.size()==0}">
						<em>Aucune société d'enregistrer.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nom</th>
									<th>Siren</th>
									<th>Ville</th>
									<th>Pays</th>
									<th>Statut</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${societes}" var="societe">
									<tr>
										<td>${societe.id}</td>
										<td>${societe.nom}</td>
										<td>${societe.siren}</td>
										<td>${societe.ville}</td>
										<td>${societe.pays}</td>
										<td>${societe.statut.code}</td>
										<td><a href="<c:url value="/societe/edit/${societe.id}"/>">Modifié</a></td>
								</c:forEach>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="footer">
				<p>
					<a href="<c:url value="/"/>">Home</a> | <a
						href="<c:url value="/statut"/>">Statut</a> | <a
						href="<c:url value="/societe"/>">Societe</a>| <a
						href="<c:url value="/user"/>">Utilisateur</a><br />
				</p>
			</div>
		</div>
	</body>
</html>
