function showRegisterModal(){
	console.log("Control in reg modal");
	document.getElementById("login-container").style.display = "none";
	document.getElementById("registerPopup").style.right = "0%";
	document.getElementById("registerPopup").style.display = "block";
}

function closeRegisterModal(){
	document.getElementById('registerPopup').style.transition = '0.75s ease-in';
	document.getElementById("registerPopup").style.right = "-100%";
	document.getElementById("popupOverlay").style.display = "none";
}

function showLogInModel(){
	document.getElementById("registerPopup").style.display = "none";
	document.getElementById("login-container").style.display = "block";
}

