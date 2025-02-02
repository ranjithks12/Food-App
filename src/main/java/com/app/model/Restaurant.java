package com.app.model;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private int deliveryTime;
	private String cusineType;
	private float ratings;
	private String address;
	private boolean isActive;
	private int adminID;
	private String imagePath;
	
	public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cusineType, float ratings,
			String address, boolean isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cusineType = cusineType;
		this.ratings = ratings;
		this.address = address;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	public Restaurant() {
		super();
	}
	
	public Restaurant(String restaurantName, int deliveryTime, String cusineType, float ratings, String address,
			boolean isActive, int adminID, String imagePath) {
		super();
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cusineType = cusineType;
		this.ratings = ratings;
		this.address = address;
		this.isActive = isActive;
		this.adminID = adminID;
		this.imagePath = imagePath;
	}
	public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cusineType, float ratings,
			String address, boolean isActive, int adminID, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cusineType = cusineType;
		this.ratings = ratings;
		this.address = address;
		this.isActive = isActive;
		this.adminID = adminID;
		this.imagePath = imagePath;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imageath) {
		this.imagePath = imageath;
	}
	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", deliveryTime="
				+ deliveryTime + ", cusineType=" + cusineType + ", ratings=" + ratings + ", address=" + address
				+ ", isActive=" + isActive + ", adminID=" + adminID + ", imageath=" + imagePath + "]";
	}
	
	
}
