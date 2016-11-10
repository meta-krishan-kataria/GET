<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "com.Metacube.Model.CarFacade" %>
<%@page import = "com.Metacube.Factory.FacadeFactory" %>
<%@page import = "com.Metacube.Model.CarVO" %>
<%@page import = "java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cars List</title>
</head>
<body>
	<div align="center">
		<h1>CarBecho.com</h1>
		<h3>List of available cars : </h3>
	
		<table>
			<tr>
				<th>Company&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>Model&nbsp;&nbsp;&nbsp;&nbsp;</th>
				<th>On Road Price&nbsp;&nbsp;&nbsp;&nbsp;</th>
			</tr>
<%
			FacadeFactory facadeFactory = new FacadeFactory();
			CarFacade facade = facadeFactory.getFacade();
	
			List<CarVO> cars = facade.getAllCars();
			for(CarVO c : cars) {
%>		
			<tr>
				<td><%=c.getCompany()%></td>
				<td><%=c.getModel()%></td>
				<td><%=c.getOnRoadPrice()%></td>
				<td>
					<a href="carDetailedViewUI.jsp?companyName=<%=c.getCompany()%>&modelName=<%=c.getModel()%>&engineInCC=<%=c.getEngineInCC()%>
								&fuelCapacity=<%=c.getFuelCapacity()%>&mileage=<%=c.getMileage()%>&price=<%=c.getPrice()%>
								&roadTax=<%=c.getRoadTax()%>&AC=<%=c.getAC()%>&powerSteering=<%=c.getPowerSteering()%>
								&accessoryKit=<%=c.getAccessoryKit()%>&onRoadPrice=<%=c.getOnRoadPrice()%>">Details</a>
				</td>
				<td>
					<a href="updateCarUI.jsp?companyName=<%=c.getCompany()%>&modelName=<%=c.getModel()%>&engineInCC=<%=c.getEngineInCC()%>
								&fuelCapacity=<%=c.getFuelCapacity()%>&mileage=<%=c.getMileage()%>&price=<%=c.getPrice()%>
								&roadTax=<%=c.getRoadTax()%>&AC=<%=c.getAC()%>&powerSteering=<%=c.getPowerSteering()%>
								&accessoryKit=<%=c.getAccessoryKit()%>&onRoadPrice=<%=c.getOnRoadPrice()%>">Modify</a>
				</td>
			</tr>
<%		
			}
%>
		</table>
	</div>
</body>
</html>