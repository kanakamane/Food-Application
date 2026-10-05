package com.tap.servelet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.foodApp.impl.OrderItemDAOImpl;
import com.foodApp.impl.OrdersDAOImpl;
import com.foodApp.modal.CartItem;
import com.foodApp.modal.OrderItem;
import com.foodApp.modal.Orders;
import com.foodApp.modal.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PlaceOrderController")
public class PlaceOrderController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Get cart from session
        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("cart");

        // Check if cart is empty
        if (cart == null || cart.isEmpty()) {

            resp.sendRedirect("cart.jsp");
            return;
        }

        // Get user ID from session
        User user = (User) session.getAttribute("loggedInUser");
        
        int userid = user.getUserid();

        // Get restaurant ID from session
        Integer restaurantId =
                (Integer) session.getAttribute("restaurantId");

        // Get payment method from checkout.jsp
        String paymentMethod =
                req.getParameter("paymentMode");

        // Create Order object
        Orders order = new Orders();

        order.setUserId(userid);
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()).toString());
        order.setPaymentMode(paymentMethod);
        order.setStatus("Pending");

        // Calculate total amount
        int totalAmount = 0;

        for (CartItem item : cart.values()) {

            totalAmount =
                    totalAmount + (item.getPrice() * item.getQuantity());
        }

        order.setTotalAmount(totalAmount);

        // ----------------------------------
        // SAVE ORDER
        // ----------------------------------

        OrdersDAOImpl orderDAO = new OrdersDAOImpl();

        int orderId = orderDAO.saveOrder(order);
        order.setOrderId(orderId);

//        System.out.println("Generated Order ID = " + orderId);

        // Check whether order was successfully inserted
        if (orderId == 0) {

            resp.sendRedirect("checkout.jsp");
            return;
        }

        // ----------------------------------
        // CREATE ORDER ITEMS
        // ----------------------------------

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem item : cart.values()) {

            int itemTotal =
                    item.getPrice() * item.getQuantity();

            OrderItem orderItem = new OrderItem();

            orderItem.setOrderId(orderId);
            orderItem.setMenuId(item.getItemID());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalAmount(itemTotal);

            orderItems.add(orderItem);
        }

        // ----------------------------------
        // SAVE ORDER ITEMS USING BATCH
        // ----------------------------------

        OrderItemDAOImpl orderItemDAO =
                new OrderItemDAOImpl();

        int[] result =
                orderItemDAO.saveOrderItems(orderItems);
        
        
      

        // ----------------------------------
        // CLEAR CART
        // ----------------------------------

        session.removeAttribute("cart");

        // Store order in session if needed
        session.setAttribute("order", order);

        // ----------------------------------
        // REDIRECT
        // ----------------------------------

        resp.sendRedirect("order_confirmation.jsp");
    }
}