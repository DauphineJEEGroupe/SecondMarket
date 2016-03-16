<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../fragments/header.jsp"/>
			<div id="content">
				<h1>Page des utilisateurs</h1>
	
				<p><span class="message">${message}</span></p>
					<p><span class="erreur">${erreur}</span></p>
				
				<p> ${sessionScope['scopedTarget.userBean'].username}</p>
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
<jsp:include page="../../fragments/footer.jsp"/>