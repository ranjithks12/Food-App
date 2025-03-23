function openLoginModal() {
	let redirectUri = document.getElementById('redirectUrl');
	document.getElementById("redirectUrl").value = window.location.href;
	document.getElementById("login-container").style.right = "0%";
	document.getElementById("login-container").style.display = "block";
	console.log(redirectUri);
}


function closeLoginPopup() {
	document.getElementById('login-container').style.transition = '0.75s ease-in';
	document.getElementById("login-container").style.right = "-100%";
}

window.onclick = function(event) {
	let modal = document.getElementById("login-container");
	if (event.target == modal) {
		modal.style.display = "none";
		//overlayModel.style.display = "none";
	}
};