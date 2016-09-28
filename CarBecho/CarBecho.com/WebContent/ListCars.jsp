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
	out.println("hello world 2");

	List<CarVO> carlist=(List)request.getAttribute("carList");
	
	/* CarVO car1=carlist.get(1);
	
	out.print(car1.getCompany()); */
	
	for(CarVO car : carlist){
	%>
		<div>
		<a href="ViewCarDetail?id=<%= car.getId() %>">
			<%=car.getId() %>
			<%=car.getModel() %>
			<%=car.getCompany() %>
			<br>
	<% 		
		
	}
	
	%>
		</a>
		</div>




</body>
</html>