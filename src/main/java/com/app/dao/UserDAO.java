package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface UserDAO {
	int addUser(User user);
	User fetchUserByUsername(String username);
	List<User> fetchAllUsers();
	int changePassword(User u, String email, String password);
}
