<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" href="css/logIn.css">
<script src="https://kit.fontawesome.com/e85887b45e.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- <div class="login-container" id="login-container">
        <h2>Login</h2>
        <form action="loginUser" method="POST">
            <div class="input-group">
                <label for="username">User name</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <input type="hidden" name="redirectUrl" id="redirectUrl">
            <button type="submit" class="btn">Sign In</button>
        </form>
        <div class="signup-link">
            <p>Don't have an account?</p>
            <a href="registerUser.jsp" class="btn-secondary">Sign Up</a>
        </div>
    </div>
</body> -->

	<div class="popup-overlay" id="popupOverlay"></div>
	<div class="login-container" id="login-container">
		<span class="popup-close" onClick="closeLoginPopup()">&times;</span>
		<h2>Login</h2>
		<form action="loginUser" method="POST">
			<div class="input-group">
				<!-- <label for="username">User name</label>  -->
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor"  width="1.5em" height="1.5em">
  				<path fill-rule="evenodd" d="M7.5 6a4.5 4.5 0 1 1 9 0 4.5 4.5 0 0 1-9 0ZM3.751 20.105a8.25 8.25 0 0 1 16.498 0 .75.75 0 0 1-.437.695A18.683 18.683 0 0 1 12 22.5c-2.786 0-5.433-.608-7.812-1.7a.75.75 0 0 1-.437-.695Z" clip-rule="evenodd" />
				</svg>
				<input type="text" id="username" name="username" placeholder="User name" required>
			</div>
			<div class="input-group">
				<!-- <label for="password">Password</label>  -->
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" width="1.5em" height="1.5em">
  				<path fill-rule="evenodd" d="M12 1.5a5.25 5.25 0 0 0-5.25 5.25v3a3 3 0 0 0-3 3v6.75a3 3 0 0 0 3 3h10.5a3 3 0 0 0 3-3v-6.75a3 3 0 0 0-3-3v-3c0-2.9-2.35-5.25-5.25-5.25Zm3.75 8.25v-3a3.75 3.75 0 1 0-7.5 0v3h7.5Z" clip-rule="evenodd" />
				</svg>
				<input type="password" id="password" name="password" placeholder="Password" required>
			</div>
			<input type="hidden" name="redirectUrl" id="redirectUrl">
			<button type="submit" class="btn">Sign In</button>
		</form>
		<div class="signup-link">
			<p>
				Don't have an account? <a onclick="showRegisterModal(); return false;"
					class="btn-secondary">Register Now</a>
			</p>
		</div>
	</div>

	<!-- JavaScript to Handle Login Popup and Redirection -->
	<script src="js/logIn.js"> </script>
	<jsp:include page="registerUser.jsp" />
</body>
</html>