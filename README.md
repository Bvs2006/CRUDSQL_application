# CRUDSQL_application
# 🖥️ Java Swing MySQL CRUD Query Executor

A simple **Java Swing desktop application** that allows users to write and execute **MySQL queries** (CRUD operations) directly from a graphical interface. The application supports **SELECT, INSERT, UPDATE, and DELETE** queries and displays results or execution status.

---

## 📌 Features

* 📝 User can type **any MySQL query**
* ▶️ Execute query by clicking **OK**
* 📊 Displays results for `SELECT` queries
* ✅ Shows affected rows for `INSERT`, `UPDATE`, `DELETE`
* ❌ Displays error messages for invalid queries
* 🔌 JDBC-based MySQL connection
* 🪟 Built using **Java Swing**

---

## 🛠️ Technologies Used

* **Java (JDK 8+)**
* **Java Swing**
* **MySQL**
* **JDBC (MySQL Connector/J)**

---

## 📂 Project Structure

```
Swing-MySQL-CRUD-App/
│
├── QueryExecutor.java
├── README.md
└── mysql-connector-j.jar
```

---

## ⚙️ Prerequisites

Before running the application, ensure you have:

* Java JDK installed
* MySQL Server installed and running
* MySQL Connector/J (`mysql-connector-j.jar`)
* Any Java IDE (VS Code, IntelliJ, Eclipse) or command line

---

## 🗄️ Database Setup

Run the following commands in MySQL:

```sql
CREATE DATABASE testdb;
USE testdb;

CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);
```

---

## 🔧 Configuration

Update the database credentials in `QueryExecutor.java`:

```java
String url = "jdbc:mysql://localhost:3306/testdb";
String user = "root";
String password = "2006";
```

---

## ▶️ How to Run

### Using IDE

1. Import the project
2. Add `mysql-connector-j.jar` to classpath
3. Run `QueryExecutor.java`

### Using Command Line

```bash
javac QueryExecutor.java
java QueryExecutor
```

---

## 🧪 Sample Queries

### INSERT

```sql
INSERT INTO student(name, age) VALUES ('Amit', 21);
```

### SELECT

```sql
SELECT * FROM student;
```

### UPDATE

```sql
UPDATE student SET age = 23 WHERE id = 1;
```

### DELETE

```sql
DELETE FROM student WHERE id = 1;
```

---

## 🚀 Future Enhancements

* Display results using `JTable`
* Login authentication
* Dropdown for CRUD operations
* Query history
* Use `PreparedStatement` for security
* Export results to CSV

---

## 📚 Learning Outcomes

* Java Swing GUI development
* JDBC connectivity
* MySQL CRUD operations
* Event handling in Java
* Desktop application design

---

## 👨‍💻 Author

**bvs**
Java & Full-Stack Developer (Learning Project)

---

##
