# STIWK2124-A1-Group5
# 📚 Accessible Reading List (ARL) — Backend

## 📌 Project Overview

This project is the backend for the Accessible Reading List (ARL) system.
It provides REST API services to manage books including create, read, update, delete, search, and pagination.

---

## ⚙️ Technologies Used

* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* GitHub

---

## 🛠️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/NurJuwana/STIWK2124-A1-Group5.git
```

---

### 2. Open the project

Open the project using:

* VS Code
* IntelliJ IDEA

---

### 3. Setup MySQL Database

Create database:

```sql
CREATE DATABASE arl_db;
```

---

### 4. Configure application.properties

Update your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/arl_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

### 5. Run the Application

Run the Spring Boot application.

Server will start at:
http://localhost:8080

---

## 🔗 API Endpoints

### 📘 Get all books (Pagination)

GET /api/books?page=0&size=5

### 🔍 Search books

GET /api/books?q=keyword

### ➕ Add book

POST /api/books

### ✏️ Update book

PUT /api/books/{id}

### ❌ Delete book

DELETE /api/books/{id}

---

## 🧾 Example Request (Add Book)

```json
{
  "title": "Sample Book",
  "author": "Ali",
  "category": "Education",
  "description": "This is a sample book"
}
```

---

## 📂 Repository

https://github.com/NurJuwana/STIWK2124-A1-Group5

---

## 📝 Notes

* Make sure MySQL is running before starting the project
* Update database username and password correctly
