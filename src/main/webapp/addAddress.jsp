<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Address</title>
<link rel="stylesheet" href="css/addAddress.css">
</head>
<body>
	<div class="address-form-container" id="addressModal">
    	<span class="popup-close" onClick="closeAddressModal()">&times;</span>
		<h2>Add Address </h2>
		<form action="addAddress" method="post">
			<div class="input-group">
				<input type="text" id="Area" name="Area" placeholder="Area" maxlength="60" required>
			</div>

			<div class="input-group">
				<input type="text" id="Street" name="Street" placeholder="Street" maxlength="60" required>
			</div>

			<div class="input-group">
				<input type="text" id="landmark" name="landmark" placeholder="Landmark" required>
			</div>

			<div class="input-group">
				<input type="text" id="City&State" name="City&State" placeholder="City & State" required>
			</div>
			
			<div class="input-group">
				<input type="tel" id="PostalCode" name="PostalCode" placeholder="Postal Code" maxlength="6" required>
			</div>

			<div class="button-group">
				<input type="hidden" name="redirctUri" id="redirectUri">
				<button type="submit" class="btn signup">Save address</button>
			</div>
			
		</form>
	</div>
	<script src="js/address.js"></script>
</body>
</html>