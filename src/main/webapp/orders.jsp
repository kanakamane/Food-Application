<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodApp.modal.Orders"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>My Orders</title>

  <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/orders.css">
</head>


<body>

	<h1>My Orders</h1>


	<div class="orders-container">

		<%

List<Orders> orders =
    (List<Orders>) request.getAttribute("orders");


if (orders != null && !orders.isEmpty()) {

    for (Orders order : orders) {

%>


		<div class="order-card">

			<h2>
				Order #<%= order.getOrderId() %>
			</h2>


			<div class="order-info">

				<p>
					<strong>Order Date:</strong>
					<%= order.getOrderDate() %>
				</p>


				<p>
					<strong>Total Amount:</strong> ₹<%= order.getTotalAmount() %>
				</p>


				<p>
					<strong>Payment Mode:</strong>
					<%= order.getPaymentMode() %>
				</p>




			</div>


			<!-- VIEW DETAILS -->

			<a class="view-btn"
				href="OrderDetailsController?orderId=<%= order.getOrderId() %>">

				View Details </a>

		</div>


		<%

    }

} else {

%>


		<div class="no-orders">

			<h2>You haven't placed any orders yetttt.</h2>

		</div>


		<%

}

%>

	</div>

</body>

</html>