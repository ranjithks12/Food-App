<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, com.app.model.MenuItem, com.app.model.Restaurant, com.app.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
List<MenuItem> menuItemList = (List<MenuItem>) session.getAttribute("menuItemList");
Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");
User user = (User) session.getAttribute("loggedUser");
%>
<title><%=restaurant.getRestaurantName() %> - Menu</title>
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/menu.css">
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
			<% if(user != null){ %>
			
			<li>
				<a href="profile.jsp" class="nav-link"> 
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
						 stroke-width="1.5" stroke="currentColor" width="1.5em" height="1.5em">
 					 	 <path stroke-linecap="round" stroke-linejoin="round"
						 d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
					</svg> 
					<span>Profile</span>
				</a>
			</li>
			
			<% } else { %>
			
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

	<!-- Main Content -->
	<div class="container">

		<%
   
    if(menuItemList != null){
    	for(MenuItem menuItem : menuItemList){
    %>
		<div class="card">
			<div class="image-container">
				<img
					src="${pageContext.request.contextPath}/images/<%= restaurant.getRestaurantName()%>/item_images/<%= menuItem.getImagePath()%>.jpg"
					alt="<%=menuItem.getItemName()%>" />
			</div>
			<div class="content">
				<h2 class="item-name"><%=menuItem.getItemName()%></h2>
				<p class="description"><%=menuItem.getItemDescription()%></p>
				<%-- <p class="availability"><%=menuItem.isAvailable() ? "Available" : "Not Available"%></p> --%>
				<p class="price">
					 &#8377; <%=menuItem.getPrice()%></p>
			</div>
			<form action="cart" method="post">
				<div class="content-buttons">
					<div>
						<label for="quantity" class="quantity-label">Quantity:</label>
						<input class="quantity" type="number" name="quantity" min="1" value="1">
					</div>
					<div>
						<input type="hidden" name="menuItemId"
							value="<%=menuItem.getMenuId()%>">
						<button class="add-to-cart" type="submit" name="action"
							value="add">Add to Cart</button>
					</div>

				</div>
			</form>
		</div>
		<%
		}
        } else {
        	%>
        	<div class="no-item-handel">
				<h1>
					Currently No menu/items available for
					<%=restaurant.getRestaurantName() %>
					restaurant!
				</h1>
			</div>
		<%
        }
         %>
	</div>
	
	

	<!-- Footer -->
	<footer class="footer">
		<p>&copy; 2024 FoodApp. All rights reserved.</p>
	</footer>
	
	
	<div class="popup-overlay" id="popupOverlay"></div>
	<div class="popupcontainer" id="popupcontainer">
        <div class="popup">
            <h2>Items already in cart</h2>
            <p>Your cart contains items from other restaurant. Would you like to reset your cart for adding items from this restaurant?</p>
            <div class="popupbuttons">
                <button type="submit" class="btn" id="hidebtn" onclick="hidePopup()">NO</button>
                <button type="submit" class="btn" onclick="">YES, START A FRESH</button>
            </div>
        </div>
    </div>
    
	<script type="text/javascript">
	
	function getQueryParam(param) {
	    const urlParams = new URLSearchParams(window.location.search);
	    return urlParams.get(param);
	}
    	window.onload = function() {
    		
/*     		const shouldShowPopup = getQueryParam("showPopup");
    	    if (shouldShowPopup === "true") {
    	        showPopup(); // Display the popup

    	        // Optionally, clean up the URL for better UX
    	        const url = new URL(window.location.href);
    	        url.searchParams.delete("showPopup");
    	        history.replaceState(null, "", url.toString());
    	    }  */    		
    		
     		if (window.location.hash === "#popupcontainer") {
    	        history.replaceState(null, null, window.location.pathname);
    	        showPopup();
    	    } else{
    	    	 hidePopup();
    	    } 
	    };
	    
	    function hidePopup(){
			document.getElementById('popupcontainer').style.display = 'none';
			document.getElementById('popupOverlay').style.display = 'none';
	    }
	    
	  	function showPopup(){
	  		document.getElementById('popupcontainer').style.display = 'block';
	  		document.getElementById('popupOverlay').style.display = 'block';
	  	}
	
	</script>

<jsp:include page="logIn.jsp" />
</body>
</html>