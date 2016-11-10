<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Car Details</title>
</head>
<body>
	<h2>Car Detailed View</h2>
	<form:form>
		<table>
			<tr>
				<td><label> Company Name : </label></td>
				<td><label>${car.companyName}</label></td>
			</tr>
			<tr>
				<td><label> Model Name : </label></td>
				<td><label>${car.modelName}</label></td>
			</tr>
			<tr>
				<td><label> Engine (in CC) : </label></td>
				<td><label>${car.engineInCC}</label></td>
			</tr>
			<tr>
				<td><label> Fuel Capacity : </label></td>
				<td><label>${car.fuelCapacity}</label></td>
			</tr>
			<tr>
				<td><label> Mileage : </label></td>
				<td><label>${car.mileage}</label></td>
			</tr>
			<tr>
				<td><label> Price : </label></td>
				<td><label>${car.price}</label></td>
			</tr>
			<tr>
				<td><label> Road Tax : </label></td>
				<td><label>${car.roadTax}</label></td>
			</tr>
			<tr>
				<td><label> AC : </label></td>
				<td><label>${car.AC}</label></td>
			</tr>
			<tr>
				<td><label> Power Steering : </label></td>
				<td><label>${car.powerSteering}</label></td>
			</tr>
			<tr>
				<td><label> Accessory Kit : </label></td>
				<td><label>${car.accessoryKit}</label></td>
			</tr>
			<tr>
				<td><label> On Road Price : </label></td>
				<td><label>${car.onRoadPrice}</label></td>
			</tr>
		</table>
	</form:form>
	<a href="/CarBechoSpringMVC/index.jsp">Home</a>
</body>
</html>