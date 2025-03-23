package com.app.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.UserDAO;
import com.app.model.User;
import com.app.util.MyConnector;

public class UserDaoImplementation implements UserDAO {
	private static final String ADD_USER_QUERY = "INSERT INTO `USER`(`user_name`, `password`, `phone_number`, `email`) VALUES (?,?,?,?)";
	private static final String FETCH_BY_USERNAME = "SELECT * FROM `USER` WHERE `user_name`=?";
	private static final String FETCH_ALL = "SELECT * FROM `USER`";
	private static final String UpDATE_PASSWORD = "UPDATE USER SET `password`=? WHERE `user_name`=?";
	private static final String UPDATE_USER = "UPDATE `USER` SET `user_name`=?, `password`=?, `phone_number`=?, `email`=? WHERE `userid`=?";
	private Connection connection = null;
	private PreparedStatement pstatement = null;
	private ResultSet result = null;
	private Statement statement = null;

	public UserDaoImplementation() { }

	@Override
	public int addUser(User user) {
		try {
			MyConnector myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			pstatement = connection.prepareStatement(ADD_USER_QUERY);
			pstatement.setString(1, user.getUser_name());
			pstatement.setString(2, user.getPassword());
			pstatement.setLong(3, user.getPhone_number());
			pstatement.setString(4, user.getEmail());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}

	@Override
	public User fetchUserByUsername(String username) {
		try {
			MyConnector myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			pstatement = connection.prepareStatement(FETCH_BY_USERNAME);
			pstatement.setString(1, username);
			result = pstatement.executeQuery();
			while (result.next()) {
				return new User(result.getInt("userid"), result.getString("user_name"), result.getString("password"),
						result.getLong("phone_number"), result.getString("email"), result.getDate("created_on"),
						result.getDate("last_login_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(result, pstatement, connection);
		}
		return null;
	}

	@Override
	public List<User> fetchAllUsers() {
		List<User> usersList = new ArrayList<User>();
		try {
			MyConnector myConnector = MyConnector.getMyConnector();
			connection = myConnector.connect();
			statement = connection.createStatement();
			ResultSet userList = statement.executeQuery(FETCH_ALL);
			while (userList.next()) {
				User user = new User(userList.getInt("user_id"), userList.getString("user_name"),
						userList.getString("password"), userList.getLong("phone_number"), userList.getString("email"),
						userList.getDate("created_on"), userList.getDate("last_login_date"));
				usersList.add(user);
			}
			return usersList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	//Has to be developed
	@Override
	public int changePassword(User u, String email, String password) {
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(UpDATE_PASSWORD);
			pstatement.setString(1, password);
			pstatement.setString(2, email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(User user) {
		try {
			connection = MyConnector.getMyConnector().connect();
			pstatement = connection.prepareStatement(UPDATE_USER);
			pstatement.setString(1, user.getUser_name());
			pstatement.setString(2, user.getPassword());
			pstatement.setLong(3, user.getPhone_number());
			pstatement.setString(4, user.getEmail());
			pstatement.setInt(5, user.getUser_id());
			return pstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnector.getMyConnector().disConnect(null, pstatement, connection);
		}
		return 0;
	}

}
