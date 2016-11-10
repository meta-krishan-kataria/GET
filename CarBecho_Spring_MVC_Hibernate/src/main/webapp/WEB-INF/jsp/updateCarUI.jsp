<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Update Cars</title>
</head>
<body>
	<h2>Update car</h2>
	<form:form method="POST" action="/CarBecho_Spring_MVC_Hibernate/updatecar" modelAttribute="car">
		<table>
			<tr>
				<td><label> Company Name </label></td>
				<td><form:input path="companyName" value="${car.companyName}" type="text" name="car_company_name" placeholder="Company Name" required="required" /></td>
			</tr>
			<tr>
				<td><label> Model Name </label></td>
				<td><form:input path="modelName" value="${car.modelName}" type="text" name="car_model_name" placeholder="Model Name" required="required" /></td>
			</tr>
			<tr>
				<td><label> Engine (in CC) </label></td>
				<td><form:input path="engineInCC" value="${car.engineInCC}" type="number" name="engineInCC" placeholder="Engine(in CC)" required="required" /></td>
			</tr>
			<tr>
				<td><label> Fuel Capacity (in Litres) </label></td>
				<td><form:input path="fuelCapacity" value="${car.fuelCapacity}" type="number" name="car_fuel_capacity" placeholder="Fuel Capacity" required="required" /></td>
			</tr>
			<tr>
				<td><label> Mileage </label></td>
				<td><form:input path="mileage" value="${car.mileage}" type="text" name="car_mileage" placeholder="Mileage" required="required" /></td>
			</tr>
			<tr>
				<td><label> Price </label></td>
				<td><form:input path="price" value="${car.price}" type="text" name="car_price" placeholder="Price" required="required" /></td>
			</tr>
			<tr>
				<td><label> Road Tax </label></td>
				<td><form:input path="roadTax" value="${car.roadTax}" type="text" name="car_road_tax" placeholder="Road Tax" required="required" /></td>
			</tr>
			<tr>
				<td><label> Does car ha AC ? </label></td>
				<c:choose>
					<c:when test="${car.getAC()} == 'Yes' ">
						<td><form:radiobutton path="AC" name="AC" value="Yes" required="required" checked="checked" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="AC" name="AC" value="No" /> No</td> 
					</c:when>
					<c:otherwise>
						<td><form:radiobutton path="AC" name="AC" value="Yes" required="required" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="AC" name="AC" value="No" checked="checked" /> No</td> 
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td><label> Does car has power steering ? </label></td>
				<c:choose>
					<c:when test="${car.getPowerSteering()} == 'Yes' ">
						<td><form:radiobutton path="powerSteering" name="PowerSteering" value="Yes" required="required" checked="checked" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="powerSteering" name="PowerSteering" value="No" /> No</td> 
					</c:when>
					<c:otherwise>
						<td><form:radiobutton path="powerSteering" name="PowerSteering" value="Yes" required="required" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="powerSteering" name="PowerSteering"	value="No" checked="checked" /> No </td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td><label> Does car has accessory kit ? </label></td>
				<c:choose>
					<c:when test="${car.getAccessoryKit()} == 'Yes' ">
						<td><form:radiobutton path="accessoryKit" name='AccessoryKit' value="Yes" required="required" checked="checked" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="accessoryKit" name='AccessoryKit' value="No" /> No </td>
					</c:when>
					<c:otherwise>
						<td><form:radiobutton path="accessoryKit" name='AccessoryKit' value="Yes" required="required" /> Yes &nbsp; &nbsp;</td>
						<td><form:radiobutton path="accessoryKit" name='AccessoryKit' value="No" checked="checked" /> No</td>
					</c:otherwise>
				</c:choose>
			<tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>