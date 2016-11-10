<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Add Cars</title>
</head>
<body>
	<div align="center">
		<h1>Add CAR</h1>
		<br /><br />
	</div>
	<div>
		<form id='addForm' method='GET' action='/CarBechoSpring/AddCarServlet'>
			<div>
				<label> CompanyName : </label>
				<input type='text' id='companyName' name='companyName' required/>
			</div>
			<div>
				<label> Model : </label>
				<input type='text' id='modelName' name='modelName' required/>
			</div>
			<div>
				<label> Engine(in CC) : </label>
				<input type='number' id='engineInCC' name='engineInCC' required/>
			</div>
			<div>
				<label> Fuel Capacity(in Litres) : </label>
				<input type='number' id='fuelCapacity' name='fuelCapacity' required/>
			</div>
			<div>
				<label> Mileage : </label>
				<input type='number' id='mileage' name='mileage' required/>
			</div>
			<div>
				<label> Price : </label>
				<input type='number' id='price' name='price' required/>
			</div>
			<div>
				<label> Road Tax : </label>
				<input type='number' id='roadTax' name='roadTax' required/>
			</div>
			<div>
				<label> AC ? : </label>
				<input type='radio' id='AC' value='Yes' name='AC' required/>Yes
				<input type='radio' id='AC' value='No' name='AC' required/>No
			</div>
			<div>
				<label> Power Steering ? : </label>
				<input type='radio' id='powerSteering' value='Yes' name='powerSteering' required/>Yes
				<input type='radio' id='powerSteering' value='No' name='powerSteering' required/>No
			</div>
			<div>
				<label> AccessoryKit ? : </label>
				<input type='radio' id='accessoryKit' name='accessoryKit' value='Yes' required/>Yes
				<input type='radio' id='accessoryKit' name='accessoryKit' value='No' required/>No
			</div>
			<div>
				<button id='addButton' type='submit'>Add</button>
			</div>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>