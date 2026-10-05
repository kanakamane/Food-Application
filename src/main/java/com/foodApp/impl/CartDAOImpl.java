package com.foodApp.impl;

import java.util.HashMap;
import java.util.Map;

import com.foodApp.modal.CartItem;

public class CartDAOImpl {

	private Map<Integer, CartItem> items;

	public CartDAOImpl() {
		this.items = new HashMap<>();
	}

	// Add an item to the cart
	public Map<Integer, CartItem> addItem(CartItem item) {
		int itemId = item.getItemID();

		if (items.containsKey(itemId)) {
			// If item already exists, increase the quantity
			CartItem existingItem = items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
		} else {
			// If item is new, add to cart
			items.put(itemId, item);
		}
		return items;
	}

	// Update the quantity of an item in the cart
	public void updateItem(int itemId, int quantity) {
		if (items.containsKey(itemId)) {
			if (quantity <= 0) {
				items.remove(itemId);
			} else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void clear() {
		items.clear();
	}

	public void remove(int itemID) {
		items.remove(itemID);
	}

}
