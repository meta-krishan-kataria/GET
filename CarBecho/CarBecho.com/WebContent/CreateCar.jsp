<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Create Car</h1>
	<form id="frm1" method="post" action="CreateCar">
		Id:<input type="number" name="id"/><br>
		
		Model:<input type="text" name="model"/><br>
		Company:<input type="text" name="company"/><br>
		Engine(CC)<input type="number" name=""/><br>
		Feul Capacity<input type="number" name=""/><br>
		Mileage<input type="number" name=""/><br>
		Price<input type="number" name=""/><br>
		
		<input type="submit" value="Save"> 

	</form>
</body>
</html>