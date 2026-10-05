package com.foodApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.modal.Restaurant;
import com.foodApp.utils.MyConnection;
import com.tap.dao.RestaurantDAO;

public class RestaurantDAOImpl implements RestaurantDAO {

    private MyConnection mycon;
    private Connection connection;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet res;

    public RestaurantDAOImpl() {
        mycon = MyConnection.getMyConnection();
        connection = mycon.connect();
    }

    @Override
    public int insertRestaurant(Restaurant r) {

        String sql = "insert into restaurant "
                + "(restaurant_id, name, cuisintype, deliverytime, address, "
                + "adminuserid, rating, isActive, imgpath) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, r.getRestaurantId());
            pstmt.setString(2, r.getName());
            pstmt.setString(3, r.getCuisineType());
            pstmt.setInt(4, r.getDeliveryTime());
            pstmt.setString(5, r.getAddress());
            pstmt.setInt(6, r.getAdminUserId());
            pstmt.setInt(7, r.getRating());
            pstmt.setInt(8, r.getIsActive());
            pstmt.setString(9, r.getImgPath());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteRestaurant(int restaurant_id) {

        try {
            pstmt = connection.prepareStatement(
                    "delete from restaurant where restaurant_id=?");

            pstmt.setInt(1, restaurant_id);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Restaurant> fetchAll() {

        List<Restaurant> restaurantList = new ArrayList<>();

        try {
            stmt = connection.createStatement();

            res = stmt.executeQuery("select * from restaurant");

            while (res.next()) {

                Restaurant restaurant = new Restaurant(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8),
                        res.getString(9)
                );

                restaurantList.add(restaurant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurantList;
    }

    @Override
    public int updateRestaurant(int restaurant_id, String name) {

        try {
            pstmt = connection.prepareStatement(
                    "update restaurant set name=? where restaurant_id=?");

            pstmt.setString(1, name);
            pstmt.setInt(2, restaurant_id);

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Restaurant fetchRestaurant(int restaurant_id) {

        try {
            pstmt = connection.prepareStatement(
                    "select * from restaurant where restaurant_id=?");

            pstmt.setInt(1, restaurant_id);

            res = pstmt.executeQuery();

            if (res.next()) {

                return new Restaurant(
                        res.getInt(1),
                        res.getString(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getString(5),
                        res.getInt(6),
                        res.getInt(7),
                        res.getInt(8),
                        res.getString(9)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
}