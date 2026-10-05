<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="com.foodApp.modal.CartItem"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Cart</title>

  <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/cart.css">

</head>


<body>


	<!-- =========================
     HOME BUTTON
========================= -->

	<div class="top-bar">

		<a href="welcome.jsp" class="home-btn"> 🏠 FoodAPP </a>

	</div>


	<!-- =========================
     PAGE HEADING
========================= -->

	<h1>🛒 My Cart</h1>


	<!-- =========================
     CART CONTAINER
========================= -->

	<div class="cart-container">

		<%

Map<Integer, CartItem> cart =
        (Map<Integer, CartItem>) session.getAttribute("cart");


if (cart != null && !cart.isEmpty()) {

    for (CartItem item : cart.values()) {

%>


		<!-- =========================
     CART ITEM
========================= -->

		<div class="cart-item">


			<!-- =========================
         ITEM DETAILS
    ========================= -->

			<div class="item-details">

				<h2>
					<%= item.getName() %>
				</h2>


				<p>
					<strong>Price:</strong> ₹<%= item.getPrice() %>
				</p>


				<p>
					<strong>Quantity:</strong>
					<%= item.getQuantity() %>
				</p>


				<p>
					<strong>Total:</strong> ₹<%= item.getPrice() * item.getQuantity() %>
				</p>

			</div>


			<!-- =========================
         CART ACTIONS
    ========================= -->

			<div class="cart-actions">


				<!-- =========================
             MINUS
        ========================= -->

				<form action="AddToCartController" method="get">

					<input type="hidden" name="menuId" value="<%= item.getItemID() %>">

					<input type="hidden" name="action" value="update">

					<button type="submit" class="minus-btn" name="quantity"
						value="<%= item.getQuantity() - 1 %>">−</button>

				</form>


				<!-- =========================
             QUANTITY
        ========================= -->

				<span class="quantity"> <%= item.getQuantity() %>

				</span>


				<!-- =========================
             PLUS
        ========================= -->

				<form action="AddToCartController" method="get">

					<input type="hidden" name="menuId" value="<%= item.getItemID() %>">

					<input type="hidden" name="action" value="update">

					<button type="submit" class="plus-btn" name="quantity"
						value="<%= item.getQuantity() + 1 %>">+</button>

				</form>


				<!-- =========================
             REMOVE
        ========================= -->

				<form action="AddToCartController" method="get">

					<input type="hidden" name="menuId" value="<%= item.getItemID() %>">

					<input type="hidden" name="action" value="remove">

					<button type="submit" class="remove-btn">Remove</button>

				</form>


			</div>

		</div>


		<%

    }

%>


		<!-- =========================
     BOTTOM BUTTONS
========================= -->

		<div class="cart-buttons">


			<!-- =========================
         LEFT BUTTONS
    ========================= -->

			<div class="left-buttons">


				<!-- ADD MORE ITEMS -->

				<form action="showMenu.jsp" method="get">

					<button type="submit" class="add-more-btn">+ Add More
						Items</button>

				</form>


				<!-- CLEAR CART -->

				<form action="AddToCartController" method="get"
					onsubmit="return confirm('Are you sure you want to clear the cart?');">

					<input type="hidden" name="action" value="clear">

					<button type="submit" class="clear-cart-btn">🗑 Clear Cart

					</button>

				</form>


			</div>
			
			<div>
			
			
			</div>


			<!-- =========================
                      CHECKOUT
            ========================= -->

			<form action="checkout.jsp" method="get">

				<button type="submit" class="checkout-btn">Proceed to
					Checkout →</button>

			</form>


		</div>


		<%

} else {

%>


		<!-- =========================
                EMPTY CART
          ========================= -->

		<div class="empty-cart">

			<h2>Your cart is empty.</h2>


			<p>Add some delicious items to your cart!</p>


			<a href="showMenu.jsp" class="empty-cart-btn"> Browse Menu </a>

		</div>


		<%

}

%>


	</div>


</body>

</html>