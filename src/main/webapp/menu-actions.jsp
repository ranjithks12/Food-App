<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, com.app.model.Restaurant, com.app.model.MenuItem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Actions</title>
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/resactions.css"/>
</head>
<body>
	<%  List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurantList"); 
		List<MenuItem> menuItems = (List<MenuItem>) session.getAttribute("menuItems");
	%>

	<nav class="navbar">
		<h1>BiteHub</h1>
		<ul>
			<li><a href="adminDashboard.jsp" class="nav-link"> <svg
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
						stroke-width="1.5" stroke="currentColor" width="1.5em"
						height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round"
							d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
					</svg> <span class="nav-element">Dashboard</span>
			</a></li>
		</ul>
	</nav>

	<div class="main-content">
		<div class="button-wrapper">
			<button type="button" class="new-res-btn" id="new-res-btn" onclick="showFormView()">Add new Menu Item</button>
		</div>

	
	<div class="add-res" id="add-res" style="display: none">
			<h2>New Menu Item Information</h2>
			<form action="menuItemActions" method="post" enctype="multipart/form-data" class="add-res-form">
				<table class="add-res-table">
					<tr>
						<td> 
							<% if(restaurants != null) { %>
							<select class="res-selection" name="restaurantName" required="required">
								<% for(Restaurant restaurant : restaurants) {  %>
									<option value="<%= restaurant.getRestaurantId() %>"> <%= restaurant.getRestaurantName() %> </option>
								<% } %>
							</select>
							<% } %>
						</td>
						<td><input type="text" oninput="filterInput(this)" name="itemName" placeholder="ItemName" required /></td>
						<td><input type="text" name="description"placeholder="Item information" required /></td>
						<td><input type="tel" id="numberInput"  name="price" placeholder="Item Price" oninput="validateNumericInput(event)" required /></td>
						<td>
							<select name="isAvailable">
								<option value="1">true</option>
								<option value="0">false</option>
							</select>
						</td>
						<td><input type="file" name="imagePath" placeholder="Image Path" /></td>
					</tr>
				</table>
				<div class="form-buttons">
					<button type="submit" name="submitAction" value="add" class="save-btn">Save</button>
					<button type="button" class="cancel-btn" id="cancel-btn" name="cancel" onclick="closeFormView()">Cancel</button>
				</div>
			</form>
		</div>
		

		<div class="get-item-det">
			<form action="menuItemActions" method="get" enctype="multipart/form-data"> 
					<% if(restaurants != null) { %>
						<select class="res-selection" name="restaurantId" required="required">
							<option>Select Restaurant Here </option>
						<% for(Restaurant restaurant : restaurants) {  %>
							<option value="<%= restaurant.getRestaurantId() %>"> <%= restaurant.getRestaurantName() %> </option>
						<% } %>
						</select>
						<button type="submit" name="submitAction" value="getDetails" class="new-res-btn"> Get Details</button>
					<% } %>
			</form>
		</div>

		
		<% if(menuItems != null) { %>
		<div class="res-list">
			<h2> Available Menu Items</h2>
			<table id="restaurant-table" class="styled-table">
		    	<thead>
		        	<tr>
		           		<th>Menu ID</th>
		           	 	<th>Item Name</th>
		        	    <th>Item Description</th>
		            	<th>Item Price</th>
		     	       	<th>Availability</th>
		            	<th>Image Path</th>
		     	       	<th>Edit Details</th>
		        	    <th>Delete</th>
		       		</tr>
		    	</thead>
		    	<tbody>
		        	<% for(MenuItem menuItem : menuItems) { %>
		        	
					 <tr>
		        		<form class="restaurant-form" action="menuItemActions" method="post" enctype="multipart/form-data">
					        <td><input type="text" id="menuItemId" name="menuItemId" class="form-field" value="<%= menuItem.getMenuId() %>" readonly></td>
					        <td><input type="text" class="form-field" oninput="filterInput(this)" name="itemName" value="<%= menuItem.getItemName() %>" readonly></td>
					        <td><input type="text" class="form-field" oninput="filterInput(this)" name="description" value="<%= menuItem.getItemDescription() %>" readonly></td>
					        <td><input type="tel" id="numberInput" class="form-field" name="itemPrice" oninput="validateNumericInput(event)" value="<%= menuItem.getPrice() %>" readonly></td>
					        <td><input type="text" class="form-field" name="isAvailable" value="<%= menuItem.getIsAvailable() %>" readonly></td>
					        <td><input type="file" class="form-field" id="imagePath" name="imagepath" readonly></td>
					        <td><button type="button"  id="edit-btn" class="edit-btn">Edit</button></td>
					        <td><button type="submit" name="submitAction" value="delete" class="delete-btn">Delete</button></td>
						</form>
				    </tr>
		        	<% } %>
		    	</tbody>
			</table>
		</div>
		<% } %>
	</div>

	<footer class="footer">
		<p>&copy; 2024 BiteHub. All rights reserved.</p>
	</footer>

<script src="js/actions.js"></script>
<script src="js/utils.js"></script>
</body>
</html>