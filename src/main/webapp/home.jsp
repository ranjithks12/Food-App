<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.app.model.Restaurant, com.app.model.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home - Restaurant Listings</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/home.css"> <!--  ?v=1.0-->
</head>
<body>
	<%
	User user = (User) session.getAttribute("loggedUser");
	%>
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
				<a href="cart.jsp"  class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg"
						fill="none" viewBox="0 0 24 24" stroke-width="1.5"
						stroke="currentColor" width="1.5em" height="1.5em">
  						<path stroke-linecap="round" stroke-linejoin="round"
							d="M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 0 0-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 0 0-16.536-1.84M7.5 14.25 5.106 5.272M6 20.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Zm12.75 0a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Z" />
					</svg>
					<span>Cart</span> 
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
		@SuppressWarnings("unchecked")
		List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
		if (restaurantList != null) { %>
		<h1 class="section-title">Featured Restaurants</h1>
	<div class="restaurant-list">
		<%
			for (Restaurant restaurant : restaurantList) {
		%>
		<div class="card">
			<div>
			<img class="restaurant-image"
				alt="<%= restaurant.getRestaurantName()%>"
				src="${pageContext.request.contextPath}/images/<%= restaurant.getRestaurantName()%>/<%= restaurant.getImagePath()%>.jpg"
				style="">
			</div>

			<div class="card-content">
				<h2 class="restaurant-name"><%=restaurant.getRestaurantName()%></h2>
				<p class="restaurant-address"><%=restaurant.getAddress()%></p>
				<div class="content">
					<p class="restaurant-rating">
						Rating:<%=restaurant.getRatings()%></p>
					<p class="restaurant-cuisine"><%=restaurant.getCusineType()%></p>
				</div>
			</div>
			<div>
			<a href="menuItem?restaurantId=<%=restaurant.getRestaurantId()%>"
					class="view-menu-btn">View Menu</a>
			</div>
		</div>
		<% }
		} else { %>
			<div class="no-res-handel">
				<h1 class="section-title">Currently No restaurants available!</h1>
			</div>
		
		<% } %>
    </div>
    
	<footer class="footer">
		<p>&copy; 2024 FoodApp. All rights reserved.</p>
	</footer>
	
    <jsp:include page="logIn.jsp" />
    
</body>
</html>
