<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.app.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Activity</title>
<link rel="stylesheet" href="css/resactions.css"/>
</head>
<body>
	<%  List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurantList"); %>
	<button type="button" class="new-res-btn" id ="new-res-btn" onclick="showFormView()">Add new Resataurant </button>
	
	<div class="add-res" id="add-res" style="display: none">
	<h2> New Restaurant Information</h2>
    <form action="restaurantActions" method="post" enctype="multipart/form-data" class="add-res-form">
        <table class="add-res-table">
            <tr>
                <td><input type="text" name="restaurantName" placeholder="Restaurant Name" required /></td>
                <td><input type="tel" name="delTime" placeholder="Delivery Time" required /></td>
                <td><input type="text" name="cusineType" placeholder="Cuisine Type" required /></td>
                <td><input type="tel" name="ratings" placeholder="Ratings" required /></td>
                <td><input type="text" name="addres" placeholder="Address" required /></td>
                <td>
                	<select name="isActive">
                	<option> true</option>
                	<option> false</option>
                	</select>
                </td>
<!--                 <td><input type="text" name="isActive" placeholder="Is Active (true/false)" required /></td> -->
                <td><input type="file" name="imagePath" placeholder="Image Path" /></td>
            </tr>
        </table>
        <div class="form-buttons">
            <button type="submit" name="action" value="add" class="save-btn">Save</button>
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
                	<td><input type="text" class="form-field" name="restaurantName" value="<%= restaurant.getRestaurantName() %>" readonly></td>
                	<td><input type="text" class="form-field" name="delTime" value="<%= restaurant.getDeliveryTime() %>" readonly></td>
                	<td><input type="text" class="form-field" name="cusineType" value="<%= restaurant.getCusineType() %>" readonly></td>
                	<td><input type="text" class="form-field" name="ratings" value="<%= restaurant.getRatings() %>" readonly></td>
                	<td><input type="text" class="form-field"  name="addres" value="<%= restaurant.getAddress() %>" readonly></td>
                	<td><input type="text" class="form-field" name="isActive" value="<%= restaurant.isActive() %>" readonly></td>
                	<td><input type="file" id="imagePath" class="form-field" name="imagePath" value="<%= restaurant.getImagePath() %>" readonly></td>
                	<td><button type="button" id="edit-btn" class="edit-btn">Edit</button></td>
                	<td><button type="submit" name="action" value="delete" class="delete-btn">Delete</button></td>
            	</form>
        	</tr>
        	<% } %>
    	</tbody>
		</table>
	</div>

    <script src="js/res-act.js"></script>
</body>
</html>