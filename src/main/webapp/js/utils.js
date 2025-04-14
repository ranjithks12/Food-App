function filterInput(input) {
	// Allow only letters (a-z, A-Z), single quote ('), and comma (,)
	input.value = input.value.replace(/[^a-zA-Z',]/g, '');
}

function validateEmail() {
	var emailField = document.getElementById("email");
	var email = emailField.value;
	var errorMessage = document.getElementById("error-message");

	// Regular expression for basic email validation (simplified)
	var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

	if (emailRegex.test(email)) {
		errorMessage.style.display = "none"; // Hide error message if valid
		return true;
	} else {
		errorMessage.style.display = "block"; // Show error message if invalid
		return false;
	}
}

function validatePhoneInput(e) {
    const input = e.target;
    let value = input.value;
    let cursorPos = input.selectionStart;

    // Remove all non-digit characters
    value = value.replace(/\D/g, '');

    // If the first digit isn't 6,7,8,9, remove it
    if (value.length > 0 && !/^[6789]/.test(value)) {
        value = value.substring(1); // remove the first invalid character
        cursorPos = cursorPos > 0 ? cursorPos - 1 : 0; // adjust cursor if necessary
    }

    // Update the input value and set the adjusted cursor position
    input.value = value;
    input.setSelectionRange(cursorPos, cursorPos);
}


function validateNumericInput(event) {
	const regex = /^[0-9]*\.?[0-9]*$/;
	let value = event.target.value;

	if (!regex.test(value)) {
		event.target.value = value.slice(0, -1);
	}
}

