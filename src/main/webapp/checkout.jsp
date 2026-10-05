<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<title>Checkout</title>

 <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/checkout.css">

</head>

<body>


	<div class="checkout-container">

		<h1 class="checkout-title">Checkout</h1>


		<!-- Checkout Form -->

		<form action="PlaceOrderController" method="post">


			<!-- Address -->

			<div class="form-group">

				<label for="address"> Delivery Address </label>

				<textarea id="address" name="address"
					placeholder="Enter your complete delivery address" required></textarea>

			</div>


			<!-- Payment Mode -->

			<div class="form-group">

				<label for="paymentMode"> Payment Mode </label> <select
					id="paymentMode" name="paymentMode" required>

					<option value="">-- Select Payment Mode --</option>

					<option value="Cash on Delivery">Cash on Delivery</option>

					<option value="UPI">UPI</option>

					<option value="Credit Card">Credit Card</option>

					<option value="Debit Card">Debit Card</option>

				</select>

			</div>


			<!-- Place Order -->

			<button type="submit" class="place-order-btn">Place Order</button>


		</form>


		<!-- Back to Cart -->

		<a href="cart.jsp" class="back-btn"> ← Back to Cart </a>


	</div>


</body>

</html>
