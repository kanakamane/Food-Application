package com.tap.servelet;

import java.io.IOException;

import com.foodApp.impl.UserDAOImpl;
import com.foodApp.modal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		User user=userDAOImpl.fetchUser(email);
		
		if(user!=null) {
			
			HttpSession session = req.getSession();
			
			session.setAttribute("loggedInUser", user);
			
			if(user.getPassword().equals(password)) {
				resp.sendRedirect("GetRestaurant");
			}
			
			else {
				resp.sendRedirect("passwordwrong.jsp");
			}
			
		}
		else {
			resp.sendRedirect("wrongemail.jsp");
		}
	}

}
