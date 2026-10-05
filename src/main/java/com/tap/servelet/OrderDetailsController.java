package com.tap.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.foodApp.impl.OrderItemDAOImpl;
import com.foodApp.impl.OrdersDAOImpl;
import com.foodApp.modal.OrderItem;
import com.foodApp.modal.Orders;


@WebServlet("/OrderDetailsController")
public class OrderDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Orders order = (Orders) req.getSession().getAttribute("order");
		
		int orderId = order.getOrderId();
		

        if (orderId == 0) {

            resp.sendRedirect("OrdersController");

            return;
        }

        


        // Get order
        OrdersDAOImpl orderDAOImpl =
                new OrdersDAOImpl();

        Orders orders =
                orderDAOImpl.getOrderById(orderId);


        // Get order items
        OrderItemDAOImpl orderItemDAOImpl =
                new OrderItemDAOImpl();

        List<OrderItem> orderItems =
                orderItemDAOImpl
                    .getOrderItemsByOrderId(orderId);


        req.setAttribute("order", order);

        req.setAttribute("orderItems", orderItems);


        // Open details page
        req.getRequestDispatcher("orderItems.jsp")
           .forward(req, resp);
	}
	

}
