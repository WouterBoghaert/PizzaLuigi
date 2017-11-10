<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
	<head>
		<c:import url="/WEB-INF/JSP/head.jsp">
			<c:param name="title" value="Statistieken"/>
		</c:import>
	</head>
	<body>
		<c:import url="/WEB-INF/JSP/menu.jsp"/>
		<h1>Statistiek</h1>
		<div>${aantalMandjes} mandje(s)</div>
		<dl>
			<dt>Welkom</dt>
			<dd>${indexRequests}</dd>
			<dt>Pizza's</dt>
			<dd>${pizzaRequests}</dd>
		</dl>
	</body>
</html>