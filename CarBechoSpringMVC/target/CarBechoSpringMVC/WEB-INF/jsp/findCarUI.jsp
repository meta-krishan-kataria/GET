<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Find Cars</title>
</head>
<body>

	<h2>Find car</h2>
	<form:form method="GET" action="/CarBechoSpringMVC/findcar">
		<table>
			<tr>
				<td><form:label path="companyName">CompanyName :</form:label></td>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<td><form:label path="modelName">Model :</form:label></td>
				<td><form:input path="modelName" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>