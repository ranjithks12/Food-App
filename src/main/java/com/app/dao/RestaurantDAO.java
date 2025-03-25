package com.app.dao;

import java.util.List;

import com.app.model.Restaurant;

public interface RestaurantDAO {
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurantId);
	List<Restaurant> getRestaurantBySearchString(String searchString);
}
