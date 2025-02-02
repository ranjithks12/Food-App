function openLoginModal() {
	let redirectUri = document.getElementById('redirectUrl');
	document.getElementById("redirectUrl").value = window.location.href;
	document.getElementById("login-container").style.display = "block";
	document.getElementById("popupOverlay").style.display = "block";
	console.log(redirectUri);
}


function closeLoginPopup() {
	document.getElementById('login-container').style.display = 'none';
	document.getElementById('popupOverlay').style.display = 'none';
}

window.onclick = function(event) {
	let modal = document.getElementById("login-container");
	let overlayModel = document.getElementById("popupOverlay");
	if (event.target == modal) {
		modal.style.display = "none";
		overlayModel.style.display = "none";
	}
};