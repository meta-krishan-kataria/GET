<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Car</title>
</head>
<body>
	<h2>Update car details</h2>
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
%>
	<div>
		<form id='updateForm' action='/CarBechoSpring/UpdateCarServlet' method='GET'>
			<div>
				<label> Company Name : </label>
				<input type='text' name='companyName' value='<%=companyName%>' placeholder='Company Name' readonly />
			</div>
			<div>
				<label> Model Name : </label>
				<input type='text' name='modelName' value='<%=modelName%>' placeholder='Model Name' readonly />
			</div>
			<div>
				<label> Engine In CC : </label>
				<input type='number' name='engineInCC' value='<%=engineInCC%>' placeholder='Engine In CC' />
			</div>
			<div>
				<label> Fuel Capacity (in Litres) : </label>
				<input type='number' name='fuelCapacity' value='<%=fuelCapacity%>' placeholder='Fuel Capacity'/>
			</div>
			<div>
				<label> Mileage : </label>
				<input type='number'  name='mileage' value='<%=mileage%>' placeholder='Mileage'/>
			</div>
			<div>
				<label> Price : </label>
				<input type='number' name='price' value="<%=price%>" placeholder='Price'/>
			</div>
			<div>
				<label> Road Tax : </label>
				<input type='number' name='roadTax' value="<%=roadTax%>" placeholder='Road Tax' />
			</div>
			<div>
				<label> AC ? : </label>
<%				String yesChecked = "";
				String noChecked = ""; 
				if(Integer.parseInt(request.getParameter("AC")) == 1){
							
					yesChecked="checked";
				}else{
						
					noChecked="checked";
				}
%>
				<input type='radio' name='AC' value='Yes' <%=yesChecked%>/> <span id='radiotext' > Yes </span> &nbsp; &nbsp;
				<input type='radio' name='AC' value='No' <%=noChecked%>/> <span id='radiotext'> No </span>
			</div>
			<div>
				<label> Power Steering ? : </label>
<%				yesChecked = "";
				noChecked = "";
				if(Integer.parseInt(request.getParameter("powerSteering")) == 1){
							
					yesChecked="checked";
				}else{
						
					noChecked="checked";
				}
%>
				<input type='radio' name='powerSteering' value='Yes' <%=yesChecked%>/> <span id='radiotext' > Yes </span> &nbsp; &nbsp;
				<input type='radio' name='powerSteering' value='No' <%=noChecked%>/> <span id='radiotext'> No </span>
			</div> 
			<div>
				<label> Accessory Kit ? : </label>
<%
				yesChecked = "";
				noChecked = "";
				if(Integer.parseInt(request.getParameter("accessoryKit")) == 1){
							
					yesChecked="checked";
				}else{
							
					noChecked="checked";
				}
%>
				<input type='radio' name='accessoryKit' value='Yes' <%=yesChecked%> /> <span id='radiotext' > Yes </span> &nbsp; &nbsp;
				<input type='radio' name='accessoryKit' value='No' <%=noChecked%>/> <span id='radiotext'> No </span>
			</div>
			<div>
				<button id='updateButton' type='submit'>Update</button>
			</div>
		</form>
	</div>
</body>
</html>