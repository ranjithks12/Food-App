function showAddressModal(){
	document.getElementById("redirectUri").value = window.location.href;
	document.getElementById("addressModal").style.left = "0%";
	document.getElementById("addressModal").style.display = "block";
	console.log(document.getElementById("redirectUri").value);
}

function closeAddressModal(){
	document.getElementById("addressModal").style.transition = '0.75s ease-in';
	document.getElementById("addressModal").style.left = "-100%";
}

document.querySelectorAll('input[name="address"]').forEach((radio) => {
    radio.addEventListener("click", (event) => {
        console.log("Clicked:", event.target.value);
		document.getElementById("placeorder-btn").style.display = "block";
    });
});

