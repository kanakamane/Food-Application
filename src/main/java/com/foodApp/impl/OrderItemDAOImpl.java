package com.foodApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.modal.OrderItem;
import com.foodApp.utils.copy.MyConnection;
import com.tap.dao.OrderItemDAO;

public class OrderItemDAOImpl implements OrderItemDAO {

    private Connection con;

    @Override
    public int[] saveOrderItems(List<OrderItem> orderItems) {

        int[] result = null;

        String sql = "INSERT INTO orderitem "
                   + "(order_id, menu_id, quantity, total_amount) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            con = MyConnection.connect();

            PreparedStatement pstmt = con.prepareStatement(sql);

            for (OrderItem item : orderItems) {

                pstmt.setInt(1, item.getOrderId());
                pstmt.setInt(2, item.getMenuId());
                pstmt.setInt(3, item.getQuantity());
                pstmt.setInt(4, item.getTotalAmount());

                pstmt.addBatch();
            }

            result = pstmt.executeBatch();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }
    
    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        String sql =
            "SELECT oi.orderitem_id, " +
            "       oi.order_id, " +
            "       oi.menu_id, " +
            "       oi.quantity, " +
            "       oi.total_amount, " +
            "       m.item_name " +
            "FROM orderitem oi " +
            "JOIN menu m ON oi.menu_id = m.menu_id " +
            "WHERE oi.order_id = ?";

        try {

            Connection con = MyConnection.connect();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);

             ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                OrderItem item = new OrderItem();

                item.setOrderItemId(
                    rs.getInt("orderitem_id")
                );

                item.setOrderId(
                    rs.getInt("order_id")
                );

                item.setMenuId(
                    rs.getInt("menu_id")
                );

                item.setQuantity(
                    rs.getInt("quantity")
                );

                item.setTotalAmount(
                    rs.getInt("total_amount")
                );

               
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}