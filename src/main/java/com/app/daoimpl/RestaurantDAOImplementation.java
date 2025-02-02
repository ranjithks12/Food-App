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

	@Override
	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
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

}
