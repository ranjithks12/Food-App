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
	if (targetFeild.type === "password") {
		targetFeild.type = "text";
		toggleShow.style.display = "none"
		toggleHide.style.display = "block"
	} else {
		targetFeild.type = "password";
		toggleHide.style.display = "none"
		toggleShow.style.display = "block"
	}
}

function toggleAdminLoginPopUp() {
	let toggleButton = document.getElementById("sgn-adm") || document.getElementById("sgn-user");
	let isAdmin = toggleButton.id === "sgn-adm";

	document.getElementById("form-header").textContent = isAdmin ? "Sign In as Admin" : "Sign In";
	document.getElementById("btnsignup").style.display = isAdmin ? "none" : "block";
	document.getElementById("signIn").textContent = isAdmin ? "Sign In as Admin" : "Sign In";

	let loginContainer = document.getElementById("login-container");
	    if (loginContainer) {
	        // Remove any existing hidden input
	        let existingInput = document.querySelector("#login-container input[name='adminLogin']");
	        if (existingInput) {
	            existingInput.remove();
	        }

	        // Add hidden input only if logging in as admin
	        if (isAdmin) {
	            let input = document.createElement("input");
	            input.type = "hidden";
	            input.name = "adminLogin";
	            input.value = "adminLoginRequest";
	            loginContainer.appendChild(input);
	        }
	    }

	if (!isAdmin) {
		document.getElementById("fgt-pwd").style.display = "inline-block";
	}

	toggleButton.textContent = isAdmin ? "Sign In as User" : "Sign In as Admin";
	toggleButton.id = isAdmin ? "sgn-user" : "sgn-adm";
}


/*
window.onclick = function(event) {
	let modal = document.getElementById("login-container");
	if (event.target == modal) {
		modal.style.display = "none";
		//overlayModel.style.display = "none";
	}
};*/