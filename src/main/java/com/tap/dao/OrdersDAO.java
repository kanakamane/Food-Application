package com.tap.dao;

import java.util.List;

import com.foodApp.modal.Orders;

public interface OrdersDAO {

	 int saveOrder(Orders order);
	 
	 List<Orders> getOrdersByUserId(int userId);

	 Orders getOrderById(int orderId);

}
