<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.foodApp.modal.Orders"%>

<%
    Orders order = (Orders) session.getAttribute("order");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Order Confirmed | FoodApp</title>

  <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/ordercon.css">

</head>

<body>

	<!-- Background -->

	<div class="circle circle1"></div>
	<div class="circle circle2"></div>

	<!-- Confetti -->

	<div class="confetti c1"></div>
	<div class="confetti c2"></div>
	<div class="confetti c3"></div>
	<div class="confetti c4"></div>
	<div class="confetti c5"></div>
	<div class="confetti c6"></div>


	<div class="container">

		<!-- Success -->

		<div class="success-circle">

			<div class="check"></div>

		</div>


		<h1>Order Placed Successfully! 🎉</h1>

		<p class="subtitle">Thank you for ordering with us! Your delicious
			food is on its way.</p>


		<!-- Delivery animation -->

		<div class="delivery">🛵</div>

		<p class="delivery-text">Your order will be prepared and delivered
			soon.</p>


		<!-- Order Details -->

		<div class="details">

			<div class="detail-row">

				<span class="label"> Order ID </span> <span class="value"> #<%= order != null ? order.getOrderId() : "N/A" %>
				</span>

			</div>


			<div class="detail-row">

				<span class="label"> Payment Method </span> <span class="value">
					<%= order != null ? order.getPaymentMode() : "N/A" %>
				</span>

			</div>


			<div class="detail-row">

				<span class="label"> Status </span> <span class="status"> <%= order != null ? order.getStatus() : "Pending" %>
				</span>

			</div>


			<div class="detail-row">

				<span class="label"> Total Amount </span> <span class="value total">
					₹<%= order != null ? order.getTotalAmount() : "0" %>
				</span>

			</div>

		</div>


		<!-- Buttons -->

		<div class="buttons">

			<a href="welcome.jsp" class="btn home-btn"> 🏠 Back to Home </a> <a
				href="OrdersController" class="btn orders-btn"> 📦 View My Orders </a>

		</div>

	</div>

</body>

</html>