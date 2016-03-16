<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../membre/fragments/header.jsp"/>
			<div id="content">
				<h1>Inscription Investisseur</h1>
	
				<p><span class="message">${message}</span></p>
					<p><span class="erreur">${erreur}</span></p>
				
				<form:form commandName="newInvestisseur" id="reg">
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
			</div>
		<jsp:include page="../membre/fragments/footer.jsp"/>