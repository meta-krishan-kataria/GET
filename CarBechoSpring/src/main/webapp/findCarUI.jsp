<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="FormCSS.css" type="text/css">
<title>Find Cars</title>
</head>
<body>
	<div align="center">
		<h3>Search the cars</h3>
		<br /><br />
	</div>
	<div>
		<form id='searchForm' action='/CarBechoSpring/FindCarServlet' method='GET'>
			<div>
				<label> Company Name : </label>
				<input type='text' name='companyName' placeholder='companyName' required/>
			</div>
			<div>
				<label> Model Name : </label>
				<input type='text' name='modelName' placeholder='modelName' required/>
			</div>
			<div>
				<button id='findButton' type='submit'>Find</button>
			</div>
		</form>
	</div> 
</body>
</html>