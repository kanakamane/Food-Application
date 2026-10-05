package com.tap.dao;

import java.util.List;

import com.foodApp.modal.Menu;

public interface MenuDAO {

    int insertMenu(Menu m);

    int deleteMenu(int menu_id);

    List<Menu> fetchAll();

    int updateMenu(int menu_id, String item_name);

    Menu fetchMenu(int menu_id);

}
