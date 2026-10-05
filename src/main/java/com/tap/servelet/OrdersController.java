package com.tap.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.foodApp.impl.OrdersDAOImpl;
import com.foodApp.modal.Orders;
import com.foodApp.modal.User;


@WebServlet("/OrdersController")
public class OrdersController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  HttpSession session = req.getSession();

	        // Get logged-in user ID
		  User user = (User) session.getAttribute("loggedInUser");
	        int userId = user.getUserid();

	        if (userId == 0) {

	            resp.sendRedirect("login.jsp");

	            return;
	        }

	        OrdersDAOImpl orderDAOImpl = new OrdersDAOImpl();

	        List<Orders> orders =
	                orderDAOImpl.getOrdersByUserId(userId);
	        
	       // System.out.println(orders);

	        req.setAttribute("orders", orders);

	        req.getRequestDispatcher("orders.jsp")
	           .forward(req, resp);
	
	}

}
