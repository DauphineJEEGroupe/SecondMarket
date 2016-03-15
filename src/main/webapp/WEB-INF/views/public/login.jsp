<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../fragments/header.jsp"/>
			<div id="content">
				<h1>Identification</h1>
				<p>
					<span class="erreur">${erreur}</span> 
				</p>
				<p>
					<span class="message"> admin@secondMarket.com / admin</span>
				</p>
				<form:form commandName="userBean" id="reg">
					<table>
						<tbody>
							<tr>
								<td><form:label path="email" >Adresse mail:</form:label></td>
								<td><form:input path="email" required="required"/></td> 
								<td><form:errors class="invalid" path="email"/></td>
							</tr>
							<tr>
								<td><form:label path="password">Mot de passe:</form:label></td>
								<td><form:password path="password" required="required"/></td> 
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
					<a href="<c:url value="/user/inscription"/>">Inscription investisseur</a><br />
			    	</p>
			</div>
			</div>
		<jsp:include page="../fragments/footer.jsp"/>