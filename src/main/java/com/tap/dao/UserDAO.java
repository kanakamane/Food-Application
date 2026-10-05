package com.tap.dao;

import java.util.List;

import com.foodApp.modal.User;

public interface UserDAO {
	
		int insertUser(User u);

		int deleteUser(int user_id);

		List<User> fetchAll();

		int updateUser(int userid, String email);

		User fetchUser(String email);

	}


