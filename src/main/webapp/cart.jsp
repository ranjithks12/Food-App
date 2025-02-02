<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.model.Cart, java.util.Map"%>
<%@ page import="com.app.model.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="css/cartStyle.css">
	<%
	Cart items = (Cart) session.getAttribute("cart");
	float totalAmount = 0.0f;
	%>
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar">
		<h1>FoodApp</h1>
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="profile.jsp">Profile</a></li>
			<li><a href="orderHistory.jsp">Order History</a></li>
			<li><a href="contact.jsp">Contact</a></li>
		</ul>
	</nav>

	<%
	if (items != null && items.getItems() != null && !items.getItems().isEmpty()) {
		Map<Integer, CartItem> cartItems = items.getItems();
		
	%>
	<h1>Your Cart</h1>
	
	<%
		for (CartItem item : cartItems.values()) {
			totalAmount += item.getSubTotal();
	%>

	<div class="container">
		<div class="cart-item">
			<div class="itemImage"></div>

			<div class="content">
				<h2 class="item-name"><%=item.getName()%></h2>
				<div>
					<form method="post" action="cart">
						<input type="hidden" name="menuItemId"
							value="<%=item.getMenuId()%>">
						<div class="quantity">
							<button type="submit" name="action" value="decrease"
								class="decrease">-</button>
							<input type="number" name="quantity"
								value="<%=item.getQuantity()%>" readonly>
							<button type="submit" name="action" value="increase"
								class="increase">+</button>
						</div>
					</form>
				</div>
				<p class="subTotal">
					&#8377;<%=String.format("%.2f", item.getSubTotal())%></p>
				<form action="cart" method="post">
					<input type="hidden" name="menuItemId"
						value="<%=item.getMenuId()%>">
					<button class="delete" type="submit" name="action" value="delete">Delete</button>
				</form>
			</div>
		</div>

	</div>
	<%
	}
	%>
	<div class="checkout-section">
		<form method="post" action="checkout">
		
		<p class="total-amount">
			Total Amount: &#8377; <input type="text" name="totalAmount" value="<%=String.format("%.2f", totalAmount)%>" readonly></p>
			<button class="checkout-btn" type="submit">Proceed to
				Checkout</button>
		</form>
	</div>
	<%
	} else {
	%>
	<h2>Your cart is empty</h2>
	<%
	}
	%>


	<!-- Footer -->
	<footer class="footer">
		<p>&copy; 2024 Restaurant. All Rights Reserved.</p>
	</footer>
</body>
</html>