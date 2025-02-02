<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="stylesheet" href="css/register.css">
<title>Insert title here</title>
</head>
<body>
	<div class="form-container">
		<h2>Register</h2>
		<form action="registerUser" method="post">
			<div class="input-group">
				<label for="username">User Name:</label> <input type="text"
					id="username" name="username" required>
			</div>

			<div class="input-group">
				<label for="phonenumber">Phone Number:</label> <input type="tel"
					id="phonenumber" name="phonenumber" required>
			</div>

			<div class="input-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>

			<div class="input-group">
				<label for="address">Address:</label> <input type="text"
					id="address" name="address" required>
			</div>

			<div class="input-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>

			<div class="input-group">
				<label for="cpassword">Confirm Password:</label> <input
					type="password" id="cpassword" name="cpassword" required>
			</div>

			<div class="button-group">
				<button type="submit" class="btn">Register</button>
			</div>
		</form>
	</div>
</body>
</html>