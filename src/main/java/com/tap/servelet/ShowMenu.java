package com.tap.servelet;

import java.io.IOException;
import java.util.List;

import com.foodApp.impl.MenuDAOImpl;
import com.foodApp.modal.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet {
	
	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		MenuDAOImpl menuDAOImpl = new MenuDAOImpl();
		
		List<Menu> mList = menuDAOImpl.fetchMenuOnRestaurant(id);
		
		req.getSession().setAttribute("menuList", mList);
		req.getSession().setAttribute("restaurantId", id);
		resp.sendRedirect("showMenu.jsp");
	}


}
