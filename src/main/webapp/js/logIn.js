function openLoginModal() {
	let redirectUri = document.getElementById("redirectUrl");
	document.getElementById("redirectUrl").value = window.location.href;
	document.getElementById("login-container").style.right = "0%";
	document.getElementById("login-container").style.display = "block";
	console.log(redirectUri);
}


function closeLoginPopup() {
	document.getElementById("login-container").style.transition = '0.75s ease-in';
	document.getElementById("login-container").style.right = "-100%";
}

function togglePassword() {
	let targetFeild = document.getElementById("password");
	let toggleShow = document.getElementById("show");
	let toggleHide = document.getElementById("hide");
	if( targetFeild.type === "password"){
		targetFeild.type = "text";
		toggleShow.style.display = "none"
		toggleHide.style.display = "block"
	} else{
		targetFeild.type = "password";
		toggleHide.style.display = "none"
		toggleShow.style.display = "block"
	}
}


window.onclick = function(event) {
	let modal = document.getElementById("login-container");
	if (event.target == modal) {
		modal.style.display = "none";
		//overlayModel.style.display = "none";
	}
};