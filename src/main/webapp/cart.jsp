<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.model.Cart, java.util.Map, com.app.model.Restaurant, com.app.model.User"%>
<%@ page import="com.app.model.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/cartStyle.css">
	<%
	Cart items = (Cart) session.getAttribute("cart");
	Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
	User user = (User) session.getAttribute("loggedUser");
	float totalAmount = 0.0f;
	%>
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar">
		<h1>BiteHub</h1>
		<ul>
			<li>
				<a class="nav-link">
					<input type="search">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
						width="1.5em" height="1.5em">
 						<path stroke-linecap="round" stroke-linejoin="round"
							d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
					</svg>
				</a>
			</li>
			
			<li>
				<a href="home.jsp"  class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"  width="1.5em" height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round" d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
					</svg>
					<span>Home</span> 
				</a>
			</li>
			<% if (user != null) { %>
			<jsp:include page="profile.jsp"/>
			<li onclick="openProfileModal(); return false;">
				<a class="nav-link"> 
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
						 stroke-width="1.5" stroke="currentColor" width="1.5em" height="1.5em">
 					 	 <path stroke-linecap="round" stroke-linejoin="round"
						 d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
					</svg> 
					<span> Profile</span>
				</a>
			</li>
			<% } else { %>
			<li onclick="openLoginModal(); return false;">
				<a class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"  width="1.5em" height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round" d="M17.982 18.725A7.488 7.488 0 0 0 12 15.75a7.488 7.488 0 0 0-5.982 2.975m11.963 0a9 9 0 1 0-11.963 0m11.963 0A8.966 8.966 0 0 1 12 21a8.966 8.966 0 0 1-5.982-2.275M15 9.75a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
					</svg>
					<span>Log In</span>
				</a>
			</li>
			
			<% } %>
			
			<li>
				<a href="about.jsp" class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" width="1.5em" height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round" d="M15 19.128a9.38 9.38 0 0 0 2.625.372 9.337 9.337 0 0 0 4.121-.952 4.125 4.125 0 0 0-7.533-2.493M15 19.128v-.003c0-1.113-.285-2.16-.786-3.07M15 19.128v.106A12.318 12.318 0 0 1 8.624 21c-2.331 0-4.512-.645-6.374-1.766l-.001-.109a6.375 6.375 0 0 1 11.964-3.07M12 6.375a3.375 3.375 0 1 1-6.75 0 3.375 3.375 0 0 1 6.75 0Zm8.25 2.25a2.625 2.625 0 1 1-5.25 0 2.625 2.625 0 0 1 5.25 0Z" />
					</svg>
					<span>About</span>
				</a>
			</li>
			
			<li>
				<a href="contact.jsp" class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" width="1.5em" height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round" d="M2.25 6.75c0 8.284 6.716 15 15 15h2.25a2.25 2.25 0 0 0 2.25-2.25v-1.372c0-.516-.351-.966-.852-1.091l-4.423-1.106c-.44-.11-.902.055-1.173.417l-.97 1.293c-.282.376-.769.542-1.21.38a12.035 12.035 0 0 1-7.143-7.143c-.162-.441.004-.928.38-1.21l1.293-.97c.363-.271.527-.734.417-1.173L6.963 3.102a1.125 1.125 0 0 0-1.091-.852H4.5A2.25 2.25 0 0 0 2.25 4.5v2.25Z" />
					</svg>
					<span>Contact</span>
				 </a>
			</li>
		</ul>
	</nav>

	<%
	if (items != null && items.getItems() != null && !items.getItems().isEmpty()) {
		Map<Integer, CartItem> cartItems = items.getItems();
	%>
	<h1 class="cart-header">Your Cart</h1>
	<%
		for (CartItem item : cartItems.values()) {
			totalAmount += item.getSubTotal();
	%>

	<div class="container">
		<div class="cart-item">
			<div class="itemImage">
			<img
					src="${pageContext.request.contextPath}/images/<%= restaurant.getRestaurantName()%>/item_images/<%= item.getItemImage()%>.jpg"
					alt="<%= item.getName()%>" />
			</div>

			<div class="content">
				<h2 class="item-name"><%=item.getName()%></h2>
				
				<p class="subTotal">
					&#8377; <%=String.format("%.2f", item.getSubTotal())%></p>
				<form action="cart" method="post">
					<input type="hidden" name="menuItemId"
						value="<%=item.getMenuId()%>">
					<button class="delete" type="submit" name="action" value="delete">Delete</button>
				</form>
			</div>
			<div>
				<div>
					<form method="post" action="cart">
						<input type="hidden" name="menuItemId"
							value="<%=item.getMenuId()%>">
						<div class="quantity">
							<button type="submit" name="action" value="decrease"
								class="decrease">-</button>
							<input class="quantity-number" type="number" name="quantity"
								value="<%=item.getQuantity()%>" readonly>
							<button type="submit" name="action" value="increase"
								class="increase">+</button>
						</div>
					</form>
				</div>
			
			</div>
		</div>

	</div>
	<%
	}
	%>
	<div class="checkout-section">
		<form method="post" action="checkout">
		
		<p class="total-amount">
			Total Amount: &#8377; <input type="text" name="totalAmount" class="totalAmount" value="<%=String.format("%.2f", totalAmount)%>" readonly></p>
			<button class="checkout-btn" type="submit">Proceed to
				Checkout</button>
		</form>
	</div>
	<%
	} else {
	%>
		<div class="no-cart-item-handel">
			<h1 class="cart-header">Your cart is empty</h1>
		</div>
	<%
	}
	%>

	<!-- Footer -->
	<footer class="footer">
		<p>&copy; 2024 Restaurant. All Rights Reserved.</p>
	</footer>
	<jsp:include page="logIn.jsp" />
</body>
</html>