

function showSpan(spanid) {
	/* alert(document.getElementById(spanid).style.visibility); */
	document.getElementById(spanid).style.visibility = "visible";

}

function hideSpan(spanid) {
	document.getElementById(spanid).style.visibility = "hidden";
}

function toggle1(spanid) {
	var span = document.getElementById(spanid).style.visibility;

	if (span == "visible") {

		//hiding span
		hideSpan(spanid);
		//changing state for toggle button
		changeToggleState("Show");

	} else if (span == "hidden") {

		//showing
		showSpan(spanid);
		//changing state for toggle button
		changeToggleState("Hide");

	} 
}

function changeToggleState(toggle) {
	document.getElementById("toggleButton").innerHTML = toggle;
}

function treatment() {
	document.getElementById("target").style.visibility = "visible";
	document.getElementById("target2").style.visibility = "visible";

}