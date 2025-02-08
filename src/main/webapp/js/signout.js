function signOut() {
	let redirectUri = document.getElementById('redirectUrl');
	document.getElementById("redirectUrl").value = window.location.href;
}