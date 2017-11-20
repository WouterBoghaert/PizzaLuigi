<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vdab" uri="http://vdab.be/tags" %>
<!DOCTYPE html>
<html lang="nl">
	<head>
		<vdab:head title="Statistieken"/>
	</head>
	<body>
		<vdab:menu/>
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