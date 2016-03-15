<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>monProfil</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="footer">
	<p>
		<a href="<c:url value="/"/>">Home</a> | <a href="<c:url value="/statut"/>">Statut</a> | <a
			href="<c:url value="/societe"/>">Societe</a><br />
	</p>
</div>
</body>
</html>
</jsp:root>