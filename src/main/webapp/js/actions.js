document.querySelectorAll(".edit-btn").forEach(button => {
	button.addEventListener("click", function(event) {
		let row = this.closest("tr");
		let inputs = row.querySelectorAll("input");

		if (this.dataset.mode !== "edit") {
			// First click - switch to edit mode
			inputs.forEach(input => {
				if (input.id !== "restaurantId" && input.id !== "imagePath") {
					input.readOnly = false;
					input.required = true;
				}
			});

			this.textContent = "Save";
			this.dataset.mode = "edit"; // Set custom data attribute to track state
			this.type = "button"; // Still button, not submitting yet

		} else {
			// Second click - save mode, submit form
			this.name = "action";
			this.value = "update";
			this.type = "submit"; // Now submit
			this.closest("form").submit(); // Manually trigger form submission
		}
	});
});

function showFormView() {
	document.getElementById("new-res-btn").style.display = "none";
	document.getElementById("add-res").style.display = "block";
}

function closeFormView() {
	document.getElementById("add-res").style.display = "none";
	document.getElementById("new-res-btn").style.display = "block";
}