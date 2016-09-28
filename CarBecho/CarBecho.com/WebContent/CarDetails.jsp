<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="model.CarVO" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello world

	<% 
	out.println("<h1>"+"Car Details "+"</h1>");

	CarVO car=(CarVO)request.getAttribute("car");
	
	out.println("Id:  "+ car.getId()  + "<br>");
	out.println("Model:  "+car.getModel()  + "<br>");
	out.println("Company:  "+car.getCompany()  + "<br>");
	out.println("Engine(CC):  "+car.getEngineInCC()  + "<br>");
	out.println("FeulCapacity:  "+car.getFuelCapacity()  + "<br>");
	out.println("Mileage:  "+car.getMileage()  + "<br>");
	out.println("Price:  "+car.getPrice()  + "<br>");
	
	
	

	
	
	%>
		





</body>
</html>