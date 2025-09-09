# 💰 Expense Tracker API

A backend REST API built with **Spring Boot**, **MySQL**, and **Hibernate/JPA** to manage personal expenses.  
This project allows users to **create, read, update, and delete (CRUD)** expense records with category and date filters.  
It is designed as a backend project and can be integrated with a frontend (React, Angular, etc.) in the future.

---

## 🚀 Features
- Add new expenses (title, amount, category, date)
- Get all expenses
- Filter expenses by **category** or **date range**
- Update an existing expense
- Delete an expense
- MySQL database integration
- REST API ready for Postman testing

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**
- **Postman** for API testing

---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/sanjay-1718/expense-tracker.git
cd expense-tracker
```
### 2. Configure the Database
- Create a MySQL database:
  ```CREATE DATABASE expense_db;```
-Update application.yml with your DB username & password.

### 3. Run the Application
```
mvn spring-boot:run
```
- Or run the ExpenseTrackerApplication main class from Eclipse/IntelliJ.

### 4. Test APIs with Postman

-Base URL: http://localhost:8080/api/expenses

-Example endpoints:

-   **POST /api/expenses** → Add new expense

-   **GET /api/expenses** → Get all expenses

-   **GET /api/expenses?category=Food** → Filter by category

-   **GET /api/expenses?startDate=2025-09-06&endDate=2025-09-09** → Filter by date range

-   **PUT /api/expenses/{id}** → Update an expense

-   **DELETE /api/expenses/{id}** → Delete an expense

---

## 📌 Notes

-This is a backend project.

-Tested with Postman.

-Can be extended with authentication, reporting, or a frontend UI later.
