package com.tap.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.foodApp.impl.MenuDAOImpl;
import com.foodApp.modal.CartItem;
import com.foodApp.modal.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get cart from session
        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) req.getSession().getAttribute("cart");

        // Create cart if it does not exist
        if (cart == null) {
            cart = new HashMap<Integer, CartItem>();
        }

        // Get action
        String action = req.getParameter("action");

        // Get menuId
        String menuIdParam = req.getParameter("menuId");

        if (menuIdParam == null || menuIdParam.isEmpty()) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        int menuId = Integer.parseInt(menuIdParam);


        // =====================================================
        // ADD ITEM
        // =====================================================

        if ("add".equals(action)) {

            String quantityParam = req.getParameter("quantity");

            int quantity = 1;

            if (quantityParam != null && !quantityParam.isEmpty()) {
                quantity = Integer.parseInt(quantityParam);
            }

            MenuDAOImpl menuDAOImpl = new MenuDAOImpl();

            Menu menu = menuDAOImpl.fetchMenu(menuId);

            if (menu != null) {

                int price = Integer.parseInt(menu.getPrice());

                // Check whether item already exists
                if (cart.containsKey(menuId)) {

                    CartItem existingItem = cart.get(menuId);

                    existingItem.setQuantity(
                            existingItem.getQuantity() + quantity
                    );

                } else {

                    CartItem cartItem = new CartItem(
                            menuId,
                            menu.getRestaurantId(),
                            menu.getItemName(),
                            quantity,
                            price
                    );

                    cart.put(menuId, cartItem);
                }
            }
        }


        // =====================================================
        // UPDATE QUANTITY
        // =====================================================

        else if ("update".equals(action)) {

            String quantityParam = req.getParameter("quantity");

            if (quantityParam != null && !quantityParam.isEmpty()) {

                int quantity = Integer.parseInt(quantityParam);

                CartItem item = cart.get(menuId);

                if (item != null) {

                    // If quantity becomes 0
                    if (quantity <= 0) {

                        cart.remove(menuId);

                    } else {

                        // Update quantity
                        item.setQuantity(quantity);
                    }
                }
            }
        }


        // =====================================================
        // REMOVE ITEM
        // =====================================================

        else if ("remove".equals(action)) {

            cart.remove(menuId);
        }
        
     // =====================================================
        // CLEAR CART
        // =====================================================
        else if ("clear".equals(action)) {

            cart.clear();
        }


        // =====================================================
        // SAVE CART BACK TO SESSION
        // =====================================================

        req.getSession().setAttribute("cart", cart);


        // Go back to cart.jsp
        resp.sendRedirect("cart.jsp");
    }
}