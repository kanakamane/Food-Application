#  Food Ordering Web Application

A full-stack **Food Ordering Web Application** developed using Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and JavaScript.

The application allows users to browse restaurants and menus, add food items to a cart, manage cart items, proceed through checkout, and place orders. The project follows a **DAO-based architecture** to separate database operations from application logic.

---

## 🚀 Features

### 👤 User Management
- User registration and login
- Session-based user authentication
- Maintains user information using `HttpSession`
- Securely manages user-specific cart and order information

### 🍽️ Restaurant & Menu
- Display available restaurants
- View restaurant menus
- Display food items with images and details
- Dynamic menu data retrieved from MySQL
- Restaurant and menu management through database operations

### 🛒 Shopping Cart
- Add food items to cart
- Increase or decrease item quantity
- Remove individual items from cart
- View complete cart details
- Calculate item totals and cart total
- Maintains cart information for the logged-in user

### 💳 Checkout & Orders
- Checkout page with customer address
- Select payment mode
- Place orders from cart
- Store order details in the database
- Store individual order items in the database
- Display order information after successful checkout

### 🗄️ Database Management
- MySQL database integration
- JDBC-based database connectivity
- DAO and DAOImpl architecture
- Separate database operations from application logic
- Uses prepared statements for database queries

---

## 🛠️ Technologies Used

### Backend
- Java
- Java Servlets
- JSP
- JDBC
- DAO Design Pattern

### Frontend
- HTML5
- CSS3
- JavaScript
- JSP

### Database
- MySQL

### Server
- Apache Tomcat

### Development Tools
- Eclipse
- MySQL
- XAMPP
- Git
- GitHub


## 🏗️ Project Architecture

The application follows a layered DAO-based architecture:

text
User
  |
  v
JSP / HTML / CSS / JavaScript
  |
  v
Servlet / Controller
  |
  v
DAO Interface
  |
  v
DAO Implementation
  |
  v
JDBC
  |
  v
MySQL Database
