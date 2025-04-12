<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message Popup</title>

<style>
.popup {
	display: block;
	position: fixed;
	top: 8%;
	left: 50%;
	transform: translateX(-50%, -50%);
	background: #333;
	color: #fff;
	padding: 15px 25px;
	border-radius: 8px;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
	font-size: 16px;
	opacity: 0;
	transition: opacity 0.5s ease-in-out, transform 0.5s ease-in-out;
	z-index: 1100;
}

/* Show animation */
.popup.show {
	display: block;
	opacity: 1;
	transform: translateX(-50%) translateY(10px);
}
</style>
</head>
<body>

	<div id="popup" class="popup">
		<%= session.getAttribute("message") %>
	</div>

	<script>
		function showMessagePopup() {
			var popup = document.getElementById("popup");
			popup.classList.add("show");

 			setTimeout(function() {
				popup.classList.remove("show"); // Remove class after 3 seconds
			}, 4000); 

		}
	</script>
</body>
</html>





</body>
</html>