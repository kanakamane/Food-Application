package com.foodApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodApp.modal.User;
import com.foodApp.utils.MyConnection;
import com.tap.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private MyConnection mycon;
	private Connection connection;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;

	public UserDAOImpl() {
		mycon = MyConnection.getMyConnection();
		connection = mycon.connect();
	}

	@Override
	public int insertUser(User u) {

		String sql = "insert into user(user_id,username,password,email,address,role,createDate,lastLoginDate) values(?,?,?,?,?,?,?,?)";

		try {

			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, u.getUserid());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getAddress());
			pstmt.setString(6, u.getRole());
			pstmt.setString(7, u.getCreateDate());
			pstmt.setString(8, u.getLastLoginDate());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteUser(int user_id) {

		try {

			pstmt = connection.prepareStatement("delete from user where userid=?");

			System.out.println("Enter the User ID to delete:");
			int id = new Scanner(System.in).nextInt();

			pstmt.setInt(1, id);

			int x = pstmt.executeUpdate();
			System.out.println("Status : " + x);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<User> fetchAll() {

		List<User> userList = new ArrayList<>();

		try {

			stmt = connection.createStatement();

			res = stmt.executeQuery("select * from user");

			while (res.next()) {

				User user = new User(

						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7),
						res.getString(8)

				);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public int updateUser(int user_id, String email) {

		Scanner sc = new Scanner(System.in);

		try {

			pstmt = connection.prepareStatement("update user set email=? where user_id=?");

			System.out.println("Enter User ID:");
			int id = sc.nextInt();

			System.out.println("Enter New Email:");
			String mail = sc.next();

			pstmt.setString(1, mail);
			pstmt.setInt(2, id);

			int x = pstmt.executeUpdate();

			System.out.println("Status : " + x);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public User fetchUser(String email) {

		try {

			pstmt = connection.prepareStatement("select * from user where email=?");

			pstmt.setString(1, email);

			res = pstmt.executeQuery();

			if (res.next()) {

				return new User(

						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getString(7),
						res.getString(8)

				);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
