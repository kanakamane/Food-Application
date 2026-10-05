<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.foodApp.modal.User"%>
<%@ page import="com.foodApp.modal.Restaurant"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>FoodApp</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/welcome.css">

</head>

<body>

	<%
    User user = (User) session.getAttribute("loggedInUser");

    List<Restaurant> restaurant =
        (List<Restaurant>) session.getAttribute("restaurant");
%>


	<!-- HEADER -->

	<div class="header">

		<div class="logo">🍴 FoodApp</div>

		<div class="header-right">

			<span class="welcome"> Welcome, <strong><%= user.getUsername() %></strong>
			</span> <a href="cart.jsp" class="cart-btn"> 🛒 Cart </a> <a
				href="login.jsp" class="logout-btn"> Logout </a>

		</div>

	</div>


	<!-- MAIN CONTENT -->

	<div class="container">

		<div class="heading">

			<h1>Discover the best restaurants</h1>

			<p>Order delicious food from your favourite restaurants</p>

		</div>


		<!-- RESTAURANTS -->

		<div class="restaurant-container">

			<%
        if (restaurant != null && !restaurant.isEmpty()) {

            for (Restaurant r : restaurant) {

                String imagePath = r.getImgPath();

                if (imagePath == null || imagePath.trim().isEmpty()) {
                    imagePath = "images/restaurant/default.png";
                }
    %>


			<div class="restaurant-card">


				<!-- IMAGE -->

				<div class="image-container">

					<img src="${pageContext.request.contextPath}/<%= imagePath %>"
						alt="<%= r.getName() %>">

					<div class="image-overlay"></div>

					<div class="restaurant-name">
						<%= r.getName() %>
					</div>

					<div class="rating">
						★
						<%= r.getRating() %>
					</div>

				</div>


				<!-- DETAILS -->

				<div class="details">

					


					<div class="address">
						<%= r.getAddress() %>
					</div>

					<div class="extra-offer">Get extra ₹125 off using FOODAPP</div>


					<a href="ShowMenu?id=<%= r.getRestaurantId() %>" class="menu-btn">
						View Menu </a>

				</div>

			</div>


			<%
            }

        } else {
    %>

			<div class="no-data">No restaurants found.</div>

			<%
        }
    %>

		</div>

	</div>

</body>
</html>