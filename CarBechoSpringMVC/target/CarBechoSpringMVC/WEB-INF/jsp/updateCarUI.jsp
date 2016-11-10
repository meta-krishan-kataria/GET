<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Add Cars</title>
</head>
<body>

	<h2>Add car</h2>
	<form:form method="POST" action="/CarBechoSpringMVC/updatecar">
		<table>
			<tr>
				<td><form:label path="companyName">CompanyName :</form:label></td>
				<td><form:input path="companyName" value="" /></td>
			</tr>
			<tr>
				<td><form:label path="modelName">Model :</form:label></td>
				<td><form:input path="modelName" /></td>
			</tr>
			<tr>
				<td><form:label path="engineInCC">Engine(in CC) : </form:label></td>
				<td><form:input path="engineInCC" /></td>
			</tr>
			<tr>
				<td><form:label path="fuelCapacity">Fuel Capacity(in Litres) : </form:label></td>
				<td><form:input path="fuelCapacity" /></td>
			</tr>
			<tr>
				<td><form:label path="mileage">Mileage : </form:label></td>
				<td><form:input path="mileage" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price : </form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="roadTax">Road Tax : </form:label></td>
				<td><form:input path="roadTax" /></td>
			</tr>
			<tr>
				<td>AC ?</td>
				<td><form:radiobutton path="hasAC" value="yes" />Yes <form:radiobutton
						path="hasAC" value="no" />No</td>
				<td><form:errors path="hasAC" /></td>
			</tr>
			<tr>
				<td>Power Steering ?</td>
				<td><form:radiobutton path="hasPowerSteering" value="yes" />Yes
					<form:radiobutton path="hasPowerSteering" value="no" />No</td>
				<td><form:errors path="hasAC" /></td>
			</tr>
			<tr>
				<td>Accessory Kit ?</td>
				<td><form:radiobutton path="hasAccessoryKit" value="yes" />Yes
					<form:radiobutton path="hasAccessoryKit" value="no" />No</td>
				<td><form:errors path="hasAC" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>