<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Find Cars</title>
</head>
<body>
	<h2>Find car</h2>
	<form:form method="GET" action="/CarBecho_Spring_MVC_Hibernate/findcar" modelAttribute="carVO">
		<table>
			<tr>
				<td><label> Company Name </label></td>
				<td><form:input path="companyName" type="text" name="car_company_name" placeholder="Company Name" required="required" /></td>
			</tr>
			<tr>
				<td><label> Model Name  </label></td>
				<td><form:input path="modelName" type="text" name="car_model_name" placeholder="Model Name" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>