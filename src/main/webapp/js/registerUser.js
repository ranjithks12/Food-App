function showRegisterModal(){
	console.log("Control in reg modal");
	document.getElementById("login-container").style.display = "none";
	document.getElementById("registerPopup").style.display = "block";
}

function closeRegisterModal(){
	document.getElementById("registerPopup").style.display = "none";
	document.getElementById("popupOverlay").style.display = "none";
}

function showLogInModel(){
	document.getElementById("registerPopup").style.display = "none";
	document.getElementById("login-container").style.display = "block";
}

