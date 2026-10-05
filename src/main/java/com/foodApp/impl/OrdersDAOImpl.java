package com.foodApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.modal.Orders;
import com.foodApp.utils.MyConnection;
import com.tap.dao.OrdersDAO;

public class OrdersDAOImpl implements OrdersDAO {

    private MyConnection con1;
    Connection con ;

    public OrdersDAOImpl() {
    	try {
    		   con1 = MyConnection.getMyConnection();
    		    con  = con1.connect();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}

    }

    @Override
    public int saveOrder(Orders order) {

        String sql = "INSERT INTO orders "
                + "(user_id, restaurant_id, order_date, total_amount, status, payment_mode) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        int orderId = 0;

        try {

            PreparedStatement pstmt = con.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setString(3, order.getOrderDate());
            pstmt.setInt(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMode());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {

                // Get generated order_id
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {

                    orderId = rs.getInt(1);

                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return orderId;
    }
    
    @Override
    public List<Orders> getOrdersByUserId(int userId) {

        List<Orders> orders = new ArrayList<>();

        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_id DESC";

        try {

            Connection con =this.con;

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Orders order = new Orders();

                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getInt("total_amount"));
               // order.setAddress(rs.getString("address"));
                order.setPaymentMode(rs.getString("payment_mode"));
                order.setOrderDate(rs.getString("order_date"));

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }


    @Override
    public Orders getOrderById(int orderId) {

        Orders order = null;

        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try {

            Connection con =this.con;

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                order = new Orders();

                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotalAmount(rs.getInt("total_amount"));
               // order.setAddress(rs.getString("address"));
                order.setPaymentMode(rs.getString("payment_mode"));
                order.setOrderDate(rs.getString("order_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }
}
