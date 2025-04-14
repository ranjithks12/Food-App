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
import com.app.util.QueryData;

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
	private static final String REMOVE_RESTAURANT = "DELETE FROM `RESTAURANT` WHERE `RESTAURANTID`=?";
	
	private static List<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
	/**
	 * Retrieves all restaurants from the database and returns them as a list.
	 * <p>
	 * This method clears the existing {@code restaurantList}, establishes a database connection,
	 * executes a query to fetch all restaurant records, and populates the list with {@code Restaurant}
	 * objects. Each restaurant is constructed using the data retrieved from the database, including
	 * restaurant ID, name, delivery time, cuisine type, ratings, address, active status, and image path.
	 * If an SQL exception occurs during execution, it is caught, printed to the console, and the method
	 * returns {@code null}. The database resources are closed in the {@code finally} block to ensure
	 * proper cleanup.
	 *
	 * @return a {@code List<Restaurant>} containing all restaurants from the database,
	 *         or {@code null} if an error occurs during database access
	 * @throws SQLException if a database access error occurs
	 */
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

	/**
	 * Retrieves a restaurant from the database by its unique ID.
	 *
	 * @param restaurantId the unique identifier of the restaurant
	 * @return a {@link Restaurant} object containing the restaurant's details if found, 
	 *         or {@code null} if no restaurant matches the provided ID or an error occurs
	 * @throws SQLException if a database access error occurs
	 */
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
	
	/**
	 * Retrieves a list of restaurants based on a search string.
	 * The search string is used to match against restaurant names using a LIKE query with wildcards.
	 * The results are stored in the restaurantList, which is cleared before each query.
	 * 
	 * @param searchString the string to search for in restaurant names
	 * @return a List of Restaurant objects matching the search criteria, or null if no matches are found
	 * @throws SQLException if a database error occurs during the query execution
	 */
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

	/**
	 * Adds a new restaurant to the database.
	 *
	 * @param restaurant the Restaurant object containing details such as name, delivery time, cuisine type,
	 *                   ratings, address, active status, and image path
	 * @return the number of rows affected by the insert operation; returns 0 if the operation fails
	 * @throws SQLException if a database access error occurs
	 */
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

	
	/**
	 * Updates a restaurant record in the database.
	 *
	 * @param restaurant the Restaurant object containing updated information
	 * @return the number of rows affected by the update operation; returns 0 if an error occurs
	 * @throws SQLException if a database access error occurs
	 */
	@Override
	public int updateRestaurant(Restaurant restaurant) {
		try {
			connection = MyConnector.getMyConnector().connect();
			QueryData data = formUpdateQuery(restaurant);
			pstatement = connection.prepareStatement(data.getQuery());
			List<Object> paramList = data.getParams();
		    for (int i = 0; i < paramList.size(); i++) {
		    	pstatement.setObject(i + 1, paramList.get(i));
		    }
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}


	/**
	 * Deletes a restaurant from the database based on the provided restaurant ID.
	 *
	 * @param restaurantId the unique identifier of the restaurant to be deleted
	 * @return the number of rows affected by the delete operation; returns 0 if the operation fails or an error occurs
	 * @throws SQLException if a database access error occurs during the execution
	 */
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
	
	/**
	 * Builds a parameterized SQL UPDATE query for the {@code RESTAURANT} table based on 
	 * the non-null fields of the given {@link Restaurant} object. 
	 * 
	 * <p>The method dynamically constructs the SQL query using placeholders (`?`) 
	 * for values, and collects the actual values into a list of parameters 
	 * in the same order. This makes the query safe for use with 
	 * {@link java.sql.PreparedStatement} to avoid SQL injection and quoting issues.</p>
	 * 
	 * <p>Only non-null fields (except for mandatory ones like DELIVERYTIME, RATINGS, 
	 * ISACTIVE) are included in the SET clause of the query. The final 
	 * WHERE clause filters the update by {@code RESTAURANTID}.</p>
	 *
	 * @param restaurant the {@link Restaurant} object containing updated field values
	 * @return a {@link QueryData} object containing the generated SQL query string and 
	 *         a list of parameter values to be set in the {@link PreparedStatement}
	 */
	private QueryData formUpdateQuery(Restaurant restaurant) {
		StringBuilder query = new StringBuilder("UPDATE `RESTAURANT` SET ");
		List<Object> params = new ArrayList<>();
		
		if (restaurant.getRestaurantName() != null) {
			query.append("`RESTAURANTNAME` = ?, ");
			params.add(restaurant.getRestaurantName());
		}
		query.append("`DELIVERYTIME` = ?, ");
		params.add(restaurant.getDeliveryTime());
		
		if (restaurant.getCusineType() != null) {
			query.append("`CUSINETYPE` = ?, ");
			params.add(restaurant.getCusineType());
		}

		if (restaurant.getAddress() != null) {
			query.append("`ADDRESS` = ?, ");
			params.add(restaurant.getAddress());
		}

		query.append("`RATINGS` = ?, ");
		params.add(restaurant.getRatings());

		query.append("`ISACTIVE` = ?, ");
		params.add(restaurant.isActive() ? 1 : 0);

		if (restaurant.getImagePath() != null) {
			query.append("`IMAGEPATH` = ?, ");
			params.add(restaurant.getImagePath());
		}
		
		// Remove trailing comma and space
		if (query.toString().endsWith(", ")) {
			query.setLength(query.length() - 2);
		}

		query.append(" WHERE `RESTAURANTID` = ?");
		params.add(restaurant.getRestaurantId());

		return new QueryData(query.toString(), params);
	}

}
