package com.tap.servelet;

import java.io.IOException;
import java.util.List;

import com.foodApp.impl.RestaurantDAOImpl;
import com.foodApp.modal.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		
		List<Restaurant> Rlist = restaurantDAOImpl.fetchAll();
		
		req.getSession().setAttribute("restaurant",Rlist );
		
		resp.sendRedirect("welcome.jsp");
		
	}
}
