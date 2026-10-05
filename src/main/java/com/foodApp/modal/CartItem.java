package com.foodApp.modal;

public class CartItem {
	
	private int itemID;
	private int restaurantID;
	private String name;
	private int quantity;
	private int price;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	
	public CartItem(int itemID, int restaurantID, String name, int quantity, int price) {
		super();
		this.itemID = itemID;
		this.restaurantID = restaurantID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemID() {
		return itemID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItem [itemID=" + itemID + ", restaurantID=" + restaurantID + ", name=" + name + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
	

}
