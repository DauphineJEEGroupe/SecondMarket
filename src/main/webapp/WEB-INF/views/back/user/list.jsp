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
				<h1>Page des utilisateurs</h1>
	
				<p><span class="message">${message}</span></p>
					<p><span class="erreur">${erreur}</span></p>
				
				<c:if test=" ${null != sessionScope['scopedTarget.userBean'] }">
					<p>${sessionScope['scopedTarget.userBean'].username}</p>
				</c:if>
				<form:form commandName="newUser" id="reg">
					<h2>Ajout d'un nouvel utilisateur</h2>
					<table>
						<tbody>
							<tr>
								<td><form:label path="nom">Nom:</form:label></td>
								<td><form:input path="nom" /></td>
								<td><form:errors class="invalid" path="nom" /></td>
							</tr>
							<tr>
								<td><form:label path="prenom">Prénom:</form:label></td>
								<td><form:input path="prenom" /></td>
								<td><form:errors class="invalid" path="prenom" /></td>
							</tr>
							<tr>
								<td><form:label path="email">Email:</form:label></td>
								<td><form:input path="email" /></td>
								<td><form:errors class="invalid" path="email" /></td>
							</tr>
							<tr>
								<td><form:label path="phoneNumber">Téléphone:</form:label></td>
								<td><form:input path="phoneNumber" /></td>
								<td><form:errors class="invalid" path="phoneNumber" /></td>
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
				<h2>Liste des utilisateurs</h2>
				<c:choose>
					<c:when test="${users.size()==0}">
						<em>Aucun utilisateur d'enregistrer.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>Nom</th>
									<th>Prénom</th>
									<th>Email</th>
									<th>Téléphone</th>
									<th>Role</th>
									<th>Actif</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user">
									<tr>
										<td>${user.id}</td>
										<td>${user.nom}</td>
										<td>${user.prenom}</td>
										<td>${user.email}</td>
										<td>${user.phoneNumber}</td>
										<td>${user.role}</td>
										<td>${user.actif}</td>
										<td><a href="<c:url value="/user/edit/${user.id}"/>">Modifié</a></td>
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
						href="<c:url value="/societe"/>">Societe</a><br />
				</p>
			</div>
		</div>
	</body>
</html>
