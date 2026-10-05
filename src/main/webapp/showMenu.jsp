<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.foodApp.modal.Menu"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Menu</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/CSS/showmenu.css">

</head>

<body>

    <!-- HEADER -->
    <div class="header">

        <a href="welcome.jsp" class="home-btn">
            🏠 FoodApp
        </a>

    </div>


    <!-- TITLE -->
    <h1 class="page-title">Menu</h1>


    <!-- MENU CONTAINER -->
    <div class="menu-container">

        <%
        ArrayList<Menu> mList =
            (ArrayList<Menu>) session.getAttribute("menuList");


        if (mList != null && !mList.isEmpty()) {

            for (Menu m : mList) {

                String imagePath = m.getImgPath();

                if (imagePath == null || imagePath.trim().isEmpty()) {
                    imagePath = "images/menu/default.jpg";
                }
        %>


        <!-- MENU CARD -->
        <div class="menu-card">


            <!-- IMAGE -->
            <div class="menu-image">

                <img src="${pageContext.request.contextPath}/<%= imagePath %>"
                     alt="<%= m.getItemName() %>">

            </div>


            <!-- MENU DETAILS -->
            <div class="menu-details">


                <!-- ITEM NAME -->
                <h2 class="item-name">
                    <%= m.getItemName() %>
                </h2>


                <!-- DESCRIPTION -->
                <p class="description">
                    <%= m.getDescription() %>
                </p>


                <!-- PRICE -->
                <div class="price">
                    ₹<%= m.getPrice() %>
                </div>


                <!-- AVAILABILITY -->
                <div class="availability">

                    <strong>Availability:</strong>

                    <%
                    if (m.getIsAvailable() != null &&
                        m.getIsAvailable().equalsIgnoreCase("yes")) {
                    %>

                        <span class="available">
                            Available
                        </span>

                    <%
                    } else {
                    %>

                        <span class="not-available">
                            Not Available
                        </span>

                    <%
                    }
                    %>

                </div>


                <!-- ADD TO CART -->

                <%
                if (m.getIsAvailable() != null &&
                    m.getIsAvailable().equalsIgnoreCase("yes")) {
                %>

                <form action="AddToCartController" method="get">

                    <input type="hidden"
                           name="menuId"
                           value="<%= m.getMenuId() %>">

                    <input type="hidden"
                           name="action"
                           value="add">


                    <div class="cart-section">

                        <label>Qty</label>

                        <select name="quantity">

                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>

                        </select>


                        <button type="submit" class="add-btn">
                            Add to Cart
                        </button>

                    </div>

                </form>


                <%
                } else {
                %>

                    <div class="unavailable-message">
                        Currently Unavailable
                    </div>

                <%
                }
                %>


            </div>

        </div>


        <%
            }

        } else {
        %>

            <div class="no-data">
                No menu items found.
            </div>

        <%
        }
        %>

    </div>

</body>
</html>