function openProfileModal() {
	document.getElementById("profile-container").style.right = "0%";
	document.getElementById("profile-container").style.display = "block";
}


function closeProfilePopup() {
	document.getElementById("profile-container").style.transition = '0.75s ease-in';
	document.getElementById("profile-container").style.right = "-100%";
}

function signOut() {
	let currentUrl = encodeURIComponent(window.location.href);  
	let signOutUrl = "signout?redirectUri=" + currentUrl; 
	window.location.href = signOutUrl;
}