$(document).ready(function(){
	
	$("select").change(function(){
		
		var employeeID=$("select :selected").val().trim();
		
		if(employeeID != 'default' ){
			
			$.ajax({
				url : "employee.json",
				dataType:"text",
				success: function(data){
					var json=$.parseJSON(data);
					$('div#data').html('Employee Name : ' + json[employeeID].name+ '<br/>' + ' Employee Email : '+ json[employeeID].email + '<br/>' + 
							' Employee DOB : '+ json[employeeID].DOB + '<br/>' + ' Employee Address : '+ json[employeeID].address);
					
				}
			});
			
		}
		
	});
	
});