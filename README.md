# 🛒 Product Management & Order Processing System (Spring Boot)

A role-based backend system built using **Spring Boot**, **Spring Security**, **JPA**, and **H2/PostgreSQL** that simulates a real-world commerce workflow with secure access control, inventory validation, and order management.

---

## 🚀 Features

### 👤 User

* Sign up & login
* View only enabled products
* Place orders with inventory validation
* View only their own order history

### 👨‍💼 Admin

* Create / update / disable / enable products
* Manage inventory (restock)
* View all orders
* Manage categories

### 👑 Super Admin

* All Admin permissions
* Create admins
* View all users
* System-wide visibility

---

## 🧠 Key Backend Concepts Implemented

* Role-Based Access Control (RBAC)
* Database-backed authentication
* Soft delete for products (enable/disable)
* Inventory validation before order placement
* User-level data isolation
* Global exception handling
* DTO-based API design
* Layered architecture (Controller → Service → Repository)

---

## 🏗️ Tech Stack

* Java 17+
* Spring Boot
* Spring Security
* Spring Data JPA / Hibernate
* H2 (dev) / PostgreSQL (prod ready)
* Maven / Gradle

---

## ⚙️ Setup Instructions

1. Clone repo
2. Run the application
3. Open H2 Console:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:orderdb
```

---

## 🔑 Default Super Admin

Created automatically on startup:

```
username: superadmin
password: super123
```

---

## 📡 Sample API Flow

### Create Admin

```
POST /auth/super/create-admin
```

### Create Category

```
POST /admin/categories
```

### Create Product

```
POST /admin/products
```

### Place Order

```
POST /orders
```

### User Order History

```
GET /orders/my
```

---

## 🧩 Design Decisions

* Soft deletes preserve order history and referential integrity
* Service layer enforces business validation
* RBAC ensures secure endpoint access
* Orders linked to users to prevent data leakage

---

## 📈 Future Improvements

* JWT authentication
* Redis caching for product queries
* Pagination & sorting
* Docker deployment
* Payment integration mock

---

## 👨‍💻 Author

Akil Pathan
Backend / Full-Stack Developer
Focused on building scalable backend systems and real-world architecture patterns.
