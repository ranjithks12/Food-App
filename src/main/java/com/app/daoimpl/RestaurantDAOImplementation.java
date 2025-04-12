package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.RestaurantDAO;
import com.app.model.Restaurant;
import com.app.util.MyConnector;

public class RestaurantDAOImplementation implements RestaurantDAO {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	private MyConnector myConnector = null;
	private PreparedStatement pstatement = null;
	private static final String FETCH_ALL = "SELECT * FROM `RESTAURANT`";
	private static final String FETCH_BY_ID = "SELECT * FROM `RESTAURANT` WHERE `RESTAURANTID`=?";
	private static final String GET_RESTAURANT_BY_SEARCH_STRING = "SELECT * FROM `RESTAURANT` WHERE `RESTAURANTNAME` LIKE ?";
	private static final String ADD_RESTAURANT = "INSERT INTO `RESTAURANT`(`RESTAURANTNAME`, `DELIVERYTIME`, `CUSINETYPE`, `RATINGS`, `ADDRESS`, `ISACTIVE`, `IMAGEPATH`) VALUES(?,?,?,?,?,?,?)";
//	private static final String UPDATE_RESTAURANT = "UPDATE `RESTAURANT` SET `RESTAURANTNAME`=?, `DELIVERYTIME`=? `CUSINETYPE`=?, `RATINGS`=? `ISACTIVE`=? `IMAGEPATH`=? WHERE `RESTAURANTID`=?";
	private static String UPDATE_RESTAURANT = "";
	private static final String REMOVE_RESTAURANT = "DELETE FROM `RESTAURANT` WHERE `RESTAURANTID`=?";
	
	private static List<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		restaurantList.clear();
		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			statement = connection.createStatement();
			result = statement.executeQuery(FETCH_ALL);
			while (result.next()) {
				restaurantList.add(new Restaurant(result.getInt("restaurantId"), result.getString("restaurantName"), 
						result.getInt("deliveryTime"),  result.getString("cusineType"), result.getFloat("ratings"),
						result.getString("address"), result.getBoolean("isActive"), result.getString("imagePath")));
			}
			return restaurantList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, statement, connection);
		}
		return null;
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		try {
			myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			pstatement  = connection.prepareStatement(FETCH_BY_ID);
			pstatement.setInt(1, restaurantId);
			result = pstatement.executeQuery();
			
			while (result.next()) {
				return new Restaurant(result.getInt("restaurantId"), result.getString("restaurantName"), 
						result.getInt("deliveryTime"), result.getString("cusineType"), result.getFloat("ratings"),
						result.getString("address"), result.getBoolean("isActive"), result.getString("imagePath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, statement, connection);
		}
		return null;
	}
	
	@Override
	public List<Restaurant> getRestaurantBySearchString(String searchString) {
		restaurantList.clear();
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement =  connection.prepareStatement(GET_RESTAURANT_BY_SEARCH_STRING);
			pstatement.setString(1, "%" + searchString + "%");
			result = pstatement.executeQuery();
			while (result.next()) {
				restaurantList.add(new Restaurant(result.getInt("restaurantId"), result.getString("restaurantName"), 
						result.getInt("deliveryTime"),  result.getString("cusineType"), result.getFloat("ratings"),
						result.getString("address"), result.getBoolean("isActive"), result.getString("imagePath")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connection);
		}
		return !restaurantList.isEmpty() ? restaurantList : null;
	}

	@Override
	public int addRestaurant(Restaurant restaurant) {
		try {
			connection = MyConnector.getMyConnector().connect();	
			pstatement =  connection.prepareStatement(ADD_RESTAURANT);
			pstatement.setString(1, restaurant.getRestaurantName());
			pstatement.setInt(2, restaurant.getDeliveryTime());
			pstatement.setString(3, restaurant.getCusineType());
			pstatement.setFloat(4, restaurant.getRatings());
			pstatement.setString(5, restaurant.getAddress());
			pstatement.setBoolean(6, restaurant.isActive());
			pstatement.setString(7, restaurant.getImagePath());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}

	@Override
	public int updateRestaurant(Restaurant restaurant) {
		try {
			connection = MyConnector.getMyConnector().connect();
			UPDATE_RESTAURANT = formUpdateQuery(restaurant);
			pstatement = connection.prepareStatement(UPDATE_RESTAURANT);

			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}

	@Override
	public int deleteRestaurant(int restaurantId) {
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(REMOVE_RESTAURANT);
			pstatement.setInt(1, restaurantId);
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}
	
	
	private static String formUpdateQuery(Restaurant restaurant) {
		StringBuilder query = new StringBuilder("UPDATE `RESTAURANT` SET ");
		List<String> params = new ArrayList<>();
		if(restaurant.getRestaurantName() != null) params.add("`RESTAURANTNAME` = '" + restaurant.getRestaurantName() + "'");
		params.add("`DELIVERYTIME` = '" + restaurant.getDeliveryTime() + "'");
		if(restaurant.getCusineType() != null) params.add("`CUSINETYPE` = '" + restaurant.getCusineType() + "'");
		if(restaurant.getAddress() != null) params.add("`ADDRESS` = '" + restaurant.getAddress() + "'");
		params.add("`RATINGS` = '" + restaurant.getRatings() + "'");
		params.add("`ISACTIVE` = " + (restaurant.isActive() ? 1 : 0));
		if(restaurant.getImagePath() != null) params.add("`IMAGEPATH` = '" + restaurant.getImagePath() + "'");
		query.append(String.join(", ", params));
		query.append(" WHERE `RESTAURANTID` = " + restaurant.getRestaurantId());
		return query.toString();
	}

}
