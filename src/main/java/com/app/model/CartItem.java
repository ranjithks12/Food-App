package com.app.model;

public class CartItem {
	private int menuId;
	private int restaurantId;
	private String name;
	private float price;
	private int quantity;
	private float subTotal;
	private String itemImage;
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public CartItem() {
		super();
	}
	public CartItem(int menuId, int restaurantId, String name, float price, int quantity, float subTotal,String itemImage) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.itemImage = itemImage;
	}
	public CartItem(int restaurantId, String name, float price, int quantity, float subTotal, String itemImage) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.itemImage = itemImage;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "CartItem [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}
	
	
	
	
}
