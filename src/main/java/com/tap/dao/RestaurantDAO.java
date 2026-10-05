package com.tap.dao;


import java.util.List;

import com.foodApp.modal.Restaurant;

public interface RestaurantDAO {

    int insertRestaurant(Restaurant r);

    int deleteRestaurant(int restaurant_id);

    List<Restaurant> fetchAll();

    int updateRestaurant(int restaurant_id, String name);

    Restaurant fetchRestaurant(int restaurant_id);
}
