$(document).ready(function(){
	
	$("#name").change(fnReflectChange );	//$(this) is by default passed to the called function
	$("#age").change(fnReflectChange );
	$("#address").change(fnReflectChange );
	
});


function fnReflectChange( ){

	var fieldName=$(this).attr('name');
	var filedValue=$(this).val();
	
	$("#logs").append(fieldName+' : '+filedValue+"<br>");

}
	



/*Issue: (Resolved)
 * calling-user-defined-function-with-params
 * 
 * http://stackoverflow.com/questions/3349112/calling-user-defined-function-with-params
 * 
 * 
	 $("#age").change(function(){
		simpleFunction("message")
	});
	
	function simpleFunction(str){
		alert("simple alert"+str);
}

*/
/*
 * Only numeric values can be animated (like "margin:30px"). String values cannot be animated 
 * (like "background-color:red"), except for the strings "show", "hide" and "toggle". 
 * These values allow hiding and showing the animated element.
 * */


/*$(this).css( {'background-color': 'yellow'} ).delay(1000).css( {'background-color': 'yellow'} );*/
/*$(this).delay("slow").css("background", "blue");*/
/*setTimeout(function(){ $(this).css("background", "red"); }, 2000);
setTimeout(function(){ $(this).css("background", "blue"); }, 2000);*/

/*	$(this).delay("slow").css("background", "red");*/

/*
$(this).animate( {'background-color': 'yellow'}, 2000, function(){
	$(this).animate( {'background-color': 'green'},2000 )
});*/

/*
//$(this).css({'background-color': 'yellow'});
$(this).animate(  $(this).css({'background-color': 'yellow'}),
		2000, 
		$(this).animate( $(this).css({'background-color': 'green'}),2000)
);*/