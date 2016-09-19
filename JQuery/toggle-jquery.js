function fnShowSpan(){
	$("#target").show();
}

$(document).ready( function(){

	$("#showSpan").click( fnShowSpan );

	$("#hideSpan").click( function(){
		$("#target").hide();
	});

	$("#toggleButton").click( function(){
		$("#target2").toggle();
		changeToggleState();

	});

}
);

function changeToggleState(){
	if($('#target2').css('display')!="none") {
		$('#toggleButton').html("Hide");
	}
	else {
		$('#toggleButton').html("Show");
	}


}