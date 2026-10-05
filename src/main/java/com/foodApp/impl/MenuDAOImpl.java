package com.foodApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.modal.Menu;
import com.foodApp.utils.MyConnection;
import com.tap.dao.MenuDAO;

public class MenuDAOImpl implements MenuDAO {

	private MyConnection mycon;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;

	public MenuDAOImpl() {

		mycon = MyConnection.getMyConnection();
		connection = mycon.connect();
	}

	@Override
	public int insertMenu(Menu m) {

		String sql = "insert into menu "
				+ "(menu_id, restaurant_id, item_name, description, price, is_available, img_parh) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, m.getMenuId());
			pstmt.setInt(2, m.getRestaurantId());
			pstmt.setString(3, m.getItemName());
			pstmt.setString(4, m.getDescription());
			pstmt.setString(5, m.getPrice());
			pstmt.setString(6, m.getIsAvailable());
			pstmt.setString(7, m.getImgPath());

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteMenu(int menu_id) {

		try {

			pstmt = connection.prepareStatement(
					"delete from menu where menu_id=?");

			pstmt.setInt(1, menu_id);

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Menu> fetchAll() {

		List<Menu> menuList = new ArrayList<>();

		try {

			stmt = connection.createStatement();

			res = stmt.executeQuery("select * from menu");

			while (res.next()) {

				Menu menu = new Menu(
						res.getInt(1),
						res.getInt(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						);

				menuList.add(menu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public int updateMenu(int menu_id, String item_name) {

		try {

			pstmt = connection.prepareStatement(
					"update menu set item_name=? where menu_id=?");

			pstmt.setString(1, item_name);
			pstmt.setInt(2, menu_id);

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Menu fetchMenu(int menu_id) {

		try {

			pstmt = connection.prepareStatement(
					"select * from menu where menu_id=?");

			pstmt.setInt(1, menu_id);

			res = pstmt.executeQuery();

			if (res.next()) {

				return new Menu(
						res.getInt(1),
						res.getInt(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	public List<Menu> fetchMenuOnRestaurant(int id) {
		
		List<Menu> menuList = new ArrayList<>();

		try {

			pstmt = connection.prepareStatement(
					"select * from menu where restaurant_id=?");

			pstmt.setInt(1, id);

			res = pstmt.executeQuery();

			while (res.next()) {

				
				menuList.add(new Menu(
						res.getInt(1),
						res.getInt(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7)
						));
			}
			return menuList;
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}
}
