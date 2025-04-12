package com.app.dao;

import java.util.List;

import com.app.model.Restaurant;

public interface RestaurantDAO {
	int addRestaurant(Restaurant restaurant);
	int updateRestaurant(Restaurant restaurant);
	int deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(int restaurantId);
	List<Restaurant> getRestaurantBySearchString(String searchString);
}
