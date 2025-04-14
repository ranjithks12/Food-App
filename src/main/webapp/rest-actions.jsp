<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.app.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Activity</title>
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/resactions.css"/>
</head>
<body>
	<%  List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurantList"); %>
	<nav class="navbar">
		<h1>BiteHub</h1>
		<ul>
			<li>
				<a href="adminDashboard.jsp" class="nav-link">
					<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"  width="1.5em" height="1.5em">
  					<path stroke-linecap="round" stroke-linejoin="round" d="m2.25 12 8.954-8.955c.44-.439 1.152-.439 1.591 0L21.75 12M4.5 9.75v10.125c0 .621.504 1.125 1.125 1.125H9.75v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21h4.125c.621 0 1.125-.504 1.125-1.125V9.75M8.25 21h8.25" />
					</svg>
					<span class="nav-element">Dashboard</span>
				</a>
			</li>
		</ul>
	</nav>
	
	
	<div class="main-content">
	<div class="button-wrapper">
  		<button type="button" class="new-res-btn" id="new-res-btn" onclick="showFormView()">Add new Restaurant</button>
	</div>
	<div class="add-res" id="add-res" style="display: none">
	<h2> New Restaurant Information</h2>
    <form action="restaurantActions" method="post" enctype="multipart/form-data" class="add-res-form">
        <table class="add-res-table">
            <tr>
                <td><input type="text" name="restaurantName" oninput="filterInput(this)" placeholder="Restaurant Name" required /></td>
                <td><input type="tel"  id="numberInput" name="delTime" placeholder="Delivery Time" oninput="validateNumericInput(event)" required /></td>
                <td><input type="text" name="cusineType" oninput="filterInput(this)" placeholder="Cuisine Type" required /></td>
                <td><input type="tel" id="numberInput" name="ratings" placeholder="Ratings" oninput="validateNumericInput(event)" required /></td>
                <td><input type="text" name="addres" oninput="filterInput(this)" placeholder="Address" required /></td>
                <td>
                	<select name="isActive">
                	<option> true</option>
                	<option> false</option>
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

	
	
	
	<div class="res-list">
	<h2> Available Restaurants</h2>
		<table id="restaurant-table" class="styled-table">
    	<thead>
        	<tr>
           		<th>Res ID</th>
           	 	<th>Name</th>
        	    <th>Delivery Time</th>
            	<th>Cuisine Type</th>
            	<th>Ratings</th>
     	       	<th>Address</th>
        	    <th>Available</th>
            	<th>Image Path</th>
     	       	<th>Operation 1</th>
        	    <th>Operation 2</th>
       		</tr>
    	</thead>
    	<tbody>
        	<% for(Restaurant restaurant : restaurants) { %>
        	<tr>
            	<form class="restaurant-form" action="restaurantActions" method="post" enctype="multipart/form-data">
                	<td><input type="text" id="restaurantId" name="restaurantId" class="form-field" value="<%= restaurant.getRestaurantId() %>" readonly></td>
                	<td><input type="text" class="form-field" name="restaurantName" oninput="filterInput(this)" value="<%= restaurant.getRestaurantName() %>" readonly></td>
                	<td><input type="tel" id="numberInput" oninput="validateNumericInput(event)" class="form-field" name="delTime" value="<%= restaurant.getDeliveryTime() %>" readonly></td>
                	<td><input type="text" class="form-field" name="cusineType" oninput="filterInput(this)" value="<%= restaurant.getCusineType() %>" readonly></td>
                	<td><input type="tel" id="numberInput" class="form-field" oninput="validateNumericInput(event)" name="ratings" value="<%= restaurant.getRatings() %>" readonly></td>
                	<td><input type="text" class="form-field"  name="addres" oninput="filterInput(this)" value="<%= restaurant.getAddress() %>" readonly></td>
                	<td><input type="text" class="form-field" name="isActive" value="<%= restaurant.isActive() %>" readonly></td>
                	<td><input type="file" id="imagePath" class="form-field" name="imagePath" value="<%= restaurant.getImagePath() %>" readonly></td>
                	<td><button type="button" id="edit-btn" class="edit-btn">Edit</button></td>
                	<td><button type="submit" name="submitAction" value="delete" class="delete-btn">Delete</button></td>
            	</form>
        	</tr>
        	<% } %>
    	</tbody>
		</table>
	</div>
	</div>
	
		<footer class="footer">
		<p>&copy; 2024 BiteHub. All rights reserved.</p>
	</footer>
	
	
<script src="js/actions.js"></script>
<script src="js/utils.js"></script>
</body>
</html>