<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Details</title>
</head>
<body>
	<h2>Car Detailed View</h2>
	<br /><br />
<%		String companyName = request.getParameter("companyName");
		String modelName = request.getParameter("modelName");
		String engineInCC = request.getParameter("engineInCC");
		String fuelCapacity = request.getParameter("fuelCapacity");
		String mileage = request.getParameter("mileage");
		String price = request.getParameter("price");
		String roadTax = request.getParameter("roadTax");
		String AC = request.getParameter("AC");
		String powerSteering = request.getParameter("powerSteering");
		String accessoryKit = request.getParameter("accessoryKit");
		String onRoadPrice = request.getParameter("onRoadPrice");
%>
	<div>
		<div>
			<label> Company Name : </label>
			<label> <%=companyName%> </label>
		</div>
		<div>
			<label> Model Name : </label>
			<label> <%=modelName%> </label>
		</div>
		<div>
			<label> Car Engine(in CC) : </label>
			<label> <%=engineInCC%> </label>
		</div>
		<div>
			<label> Fuel Capacity (in Litres) : </label>
			<label> <%=fuelCapacity%> </label>
		</div>
		<div>
			<label> Mileage : </label>
			<label> <%=mileage%> </label>
		</div>
		<div>
			<label> Price : </label>
			<label> <%=price%> </label>
		</div>
		<div>
			<label> Road Tax : </label>
			<label> <%=roadTax%> </label>
		</div>
		<div>
			<label> AC ? : </label>
<%
			String isAcPresent = "Not present"; 
			if(Integer.parseInt(AC) == 1){
					  
				isAcPresent = "present";
			}
%>
			<label> <%=isAcPresent%> </label>
		</div>
		<div>
			<label> Power steering ? : </label>
<%
			String isPowerSteeringPresent = "Not present";
			if(Integer.parseInt(powerSteering) == 1){
					
				isPowerSteeringPresent = "present";
			}
%>
			<label> <%=isPowerSteeringPresent %> </label>
		</div> 
		<div>
			<label> Accessory kit ? : </label>
<%
			String isAccessoryKitPresent = "Not present";
			if(Integer.parseInt(accessoryKit) == 1){	
				
				isAccessoryKitPresent = "present";
			}
			%>
			<label> <%=isAccessoryKitPresent %> </label>
		</div>
		<div>
			<label> On Road Price : </label>
			<label> <%=onRoadPrice%> </label>
		</div>
		<div>
			<a href="index.jsp">Home</a>
		</div>
	</div>
</body>
</html>