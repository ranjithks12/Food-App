<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.app.model.PaymentMethod, com.app.model.User, com.app.model.Address"%>
<%@ page import="com.app.model.Cart,java.util.Map, com.app.model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/orderConfirmation.css">
<%
List<PaymentMethod> paymentMethods = (List<PaymentMethod>) session.getAttribute("paymentmethods");
List<Address> addresses = (List<Address>) session.getAttribute("addresses");
float amount = (float) session.getAttribute("totalAmount");
User user = (User) session.getAttribute("loggedUser");
Cart cartItems = (Cart) session.getAttribute("cart");
 %>
</head>
<body>
	<nav class="navbar">
		<h1>BiteHub</h1>
		<ul>
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
 	
	 <% if (user != null) { %>
	 <form action="placeorder" method="post">
	 <div> 
	 	<div class="page-header"> 
	 		<h1>Order Summary</h1>
	 	</div>
	 
		 <div class="content">
        	<div class="content information">
            	<% if(addresses != null && !addresses.isEmpty()) { %>
            	<div class="address-container">      
            		<% for (Address address: addresses) { %>
            		<div class="addresses">
                		<input type="radio" name="address" id="address" value="<%= address.getAddresId() %>">
                		<div>
                    		<p><%= address.getArea() %></p>
                    		<p><%= address.getStreet() %></p>
                    		<p><%= address.getLandMark() %></p>
                    		<p><%= address.getCityAndState() %> - <%= address.getPostalCode() %></p>
                		</div>
            		</div>
            		<% } %>
        		</div>
            	<p id="select-address"> Select any address to deliver. </p>
            	<% } else { %>
            		<p id="select-address"> Add the address to deliver. </p>
            	<% } %>
            
           		<div>
                	<button class="buttons" onclick="showAddressModal(); return false;">Add address</button>
            	</div>          
        	</div>
        
        	<div class="content payment">
	        	<table>
    		    	<tr> 
        				<th> Item Name</th>
        				<th> Quantity</th>
        				<th> Total</th>
        			</tr>
        			<% Map<Integer, CartItem> items = cartItems.getItems();
        			for (CartItem item : items.values()) { %>
        			<tr> 
        				<td> <%= item.getName() %></td>
        				<td> <%= item.getQuantity() %></td>
        				<td> <%= item.getSubTotal() %></td>
        			</tr>
        			<% } %>
       		 	</table>
       <!--  <form action="placeorder" method="post"> -->
            	<div>
                	<span class="payment-content">Payable Amount: </span><span class="payment-content payment-amount">  &#8377; <%= amount%></span>
            	</div>
            	<% if (paymentMethods != null) { %>
            	<div>
                	<label class="payment-content">Select payment method: </label>
                	<select name="dropdown-value">
                   	<% for (PaymentMethod paymentMethod : paymentMethods) { 
                   		if(paymentMethod.isAvailable()) { %>
							<option class="dropdown-value"><%=paymentMethod.getPaymentMethodName()%></option>
						<% } } %>
                	</select>
            	</div>
               	<% } %>
            	<button class="buttons" id="placeorder-btn">Place order</button>
        	</div>
        </div>
	</div>
</form>

   <% } else { %>
   		<div class="content">
	 		<p class="payment-content"> Please Sign in to continue to complete order </p>
		 	<button class="buttons" onclick="openLoginModal(); return false;">Sign in</button>
		</div>
   <% } %>

	 



	<footer class="footer">
		<p>&copy; 2024 FoodApp. All rights reserved.</p>
	</footer>
	<jsp:include page="logIn.jsp" />
	<jsp:include page="addAddress.jsp" />
	<jsp:include page="confPopup.jsp"/>
	<script type="text/javascript">
		window.onload = function( ){
			<% if(session.getAttribute("showPopup") != null) { %>
				displayPopUp();
			<% session.removeAttribute("showPopup"); } %>
		}
	</script>
	<script src="js/address.js"></script>
</body>
</html>