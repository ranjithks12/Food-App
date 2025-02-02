<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/logIn.css">
</head>
<body>
	<div class="login-container">
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
            <button type="submit" class="btn">Sign In</button>
        </form>
        <div class="signup-link">
            <p>Don't have an account?</p>
            <a href="registerUser.jsp" class="btn-secondary">Sign Up</a>
        </div>
    </div>
</body>
</html>