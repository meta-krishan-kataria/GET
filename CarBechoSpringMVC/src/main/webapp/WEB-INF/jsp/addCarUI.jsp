<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Cars</title>
</head>
<body>
	<h2>Add car</h2>
	<form:form method="POST" action="/CarBechoSpringMVC/addcar" modelAttribute="carVO">
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
				<td><label> Engine (in CC) </label></td>
				<td><form:input path="engineInCC" type="number" name="engineInCC" placeholder="Engine(in CC)" required="required"/></td>
			</tr>
			<tr>
				<td><label> Fuel Capacity (in Litres) </label></td>
				<td><form:input path="fuelCapacity" type="number" name="car_fuel_capacity" placeholder="Fuel Capacity" required="required"/></td>
			</tr>
			<tr>
				<td><label> Mileage  </label></td>
				<td><form:input path="mileage" type="text"  name="car_mileage" placeholder="Mileage" required="required"/></td>
			</tr>
			<tr>
				<td><label> Price </label></td>
				<td><form:input path="price" type="text" name="car_price" placeholder="Price" required="required"/></td>
			</tr>
			<tr>
				<td><label> Road Tax </label></td>
				<td><form:input path="roadTax" type="text" name="car_road_tax" placeholder="Road Tax"  required="required"/></td>
			</tr>
			<tr>
				<td><label> Does car has AC ? </label></td>
				<td><form:radiobutton path="AC" name="AC" value="Yes" required="required"/> <span id='radiotext'> Yes </span> &nbsp; &nbsp;</td>
				<td><form:radiobutton path="AC" name="AC" value="No"/> <span id='radiotext'> No </span></td>
			</tr>
			<tr>
				<td><label> Does car has power steering ? </label></td>
				<td><form:radiobutton path="PowerSteering" name="powerSteering" value="Yes" required="required"/> <span id='radiotext'> Yes </span> &nbsp; &nbsp;</td>
				<td><form:radiobutton path="PowerSteering" name="powerSteering" value="No"/> <span id='radiotext'> No </span></td>			
			</tr>
			<tr>
				<td><label> Does car has accessory kit ? </label></td>
				<td><form:radiobutton path="AccessoryKit" name='accessoryKit' value="Yes" required="required"/> <span id='radiotext' > Yes </span> &nbsp; &nbsp;</td>
				<td><form:radiobutton path="AccessoryKit" name='accessoryKit' value="No"/> <span id='radiotext'> No </span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>