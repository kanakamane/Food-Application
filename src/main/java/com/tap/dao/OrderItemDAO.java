package com.tap.dao;

import java.util.List;

import com.foodApp.modal.OrderItem;

public interface OrderItemDAO {

    int[] saveOrderItems(List<OrderItem> orderItems);
    
    List<OrderItem> getOrderItemsByOrderId(int orderId);

}