<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.app.model.PaymentMethod"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<link rel="stylesheet" href="css/orderConfirmation.css">
<%
List<PaymentMethod> paymentMethods = (List<PaymentMethod>) session.getAttribute("paymentmethods");
float amount = (float) session.getAttribute("totalAmount");
if (paymentMethods != null) {
%>
</head>
<body>
	<nav class="navbar">
		<h1>FoodApp</h1>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="orderHistory.jsp">Order History</a></li>
			<li><a href="about.jsp">About</a></li>
			<li><a href="contact.jsp">Contact</a></li>
		</ul>
	</nav>

	<section class="content">
		<div class="conttent_info">
			<button class="buttons">Add Address</button>
			<button class="buttons">Sign Up</button>
		</div>
		<form action="placeorder" method="post">
			<div class="conttent_info payment">
				<div>
					<p>Payble amount:</p> <label> <%= amount%></label>
					<label>Select payment method: </label> <select
						class="paymentdropdown" name="dropdown-value">
						<%
						for (PaymentMethod paymentMethod : paymentMethods) {
						%>
						<option class="dropdown-value"><%=paymentMethod.getPaymentMethodName()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div>
					<button class="buttons">Place order</button>
				</div>
			</div>
		</form>
		<%
		}
		%>
	</section>



	<footer class="footer">
		<p>&copy; 2024 FoodApp. All rights reserved.</p>
	</footer>
</body>
</html>