<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Login Page</title>

   <link rel="stylesheet"
      href="${pageContext.request.contextPath}/CSS/style.css">

</head>


<body>


    <form action="login" method="post" class="login-form">

        <h2>Login</h2>


        <div class="form-group">

            <label for="email">
                Email
            </label>

            <input type="text"
                   id="email"
                   name="email"
                   placeholder="Enter your email">

        </div>


        <div class="form-group">

            <label for="password">
                Password
            </label>

            <input type="password"
                   id="password"
                   name="password"
                   placeholder="Enter your password">

        </div>


        <input type="submit"
               value="Login"
               class="login-btn">


        <div class="register">

            Don't have an account?

            <a href="#">
                Register
            </a>

        </div>

    </form>


</body>

</html>