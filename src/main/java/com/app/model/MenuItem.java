package com.app.model;

public class MenuItem {
	
	private int menuId;
	private int restaurantId;
    private String itemName;
    private String itemDescription;
    private float price;
    private int isAvailable;
    private String imagePath;
	public MenuItem() {
		super();
	}
	
	public MenuItem(int menuId, int restaurantId, String itemName, String itemDescription, float price,
			int isAvailable, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public MenuItem(int restaurantId, String itemName, String itemDescription, float price, int isAvailable,
			String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "MenuItem [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName
				+ ", itemDescription=" + itemDescription + ", price=" + price + ", isAvailable=" + isAvailable
				+ ", imagePath=" + imagePath + "]";
	}
    
}
