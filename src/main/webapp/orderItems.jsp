<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodApp.modal.Orders"%>
<%@ page import="com.foodApp.modal.OrderItem"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Order Details</title>

  <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/orderItem.css">


</head>


<body>


	<div class="container">


		<%

Orders order =
    (Orders) request.getAttribute("order");

List<OrderItem> orderItems =
    (List<OrderItem>) request.getAttribute("orderItems");

%>


		<h1>
			Order #<%= order.getOrderId() %>
		</h1>


		<!-- ORDER SUMMARY -->

		<div class="order-summary">

			<p>
				<strong>Order Date:</strong>
				<%= order.getOrderDate() %>
			</p>



			<p>
				<strong>Payment:</strong>
				<%= order.getPaymentMode() %>
			</p>

			<p>
				<strong>Order Total:</strong> ₹<%= order.getTotalAmount() %>
			</p>

		</div>


		<h2>Order Items</h2>


		<%

if (orderItems != null && !orderItems.isEmpty()) {

    for (OrderItem item : orderItems) {

%>


		<div class="order-item">


			<div>



				<div class="item-info">

					Menu ID:
					<%= item.getMenuId() %>

				</div>

			</div>


			<div>

				<p>

					<strong>Quantity:</strong>

					<%= item.getQuantity() %>

				</p>

				<p>

					<strong>Total:</strong> ₹<%= item.getTotalAmount() %>

				</p>

			</div>


		</div>


		<%

    }

} else {

%>


		<p>No items found for this order.</p>


		<%

}

%>


		<a href="OrdersController" class="back-btn"> ← Back to My Orders </a>


	</div>


</body>

</html>