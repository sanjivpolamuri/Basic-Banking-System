# Banking Management System Using JDBC - README  

## 📌 **Project Overview**  
This is a **Banking Management System** developed using **Java and JDBC** (Java Database Connectivity). It allows users to perform banking operations such as **account creation, deposits, withdrawals, balance inquiries, and transaction history**. The system interacts with a **MySQL database** to store and manage customer and transaction details efficiently.  

## 🛠 **Tech Stack**  
- **Java** (Core Java, JDBC)  
- **MySQL** (Database)  
- **JDBC Driver** (MySQL Connector)  
- **Eclipse/IntelliJ** (IDE - Optional)  

## ✨ **Features**  
✅ **User Authentication** (Login/Signup)  
✅ **Account Management** (Create, Delete)  
✅ **Deposit & Withdrawal**  
✅ **Balance Inquiry**  
✅ **Transaction History**  
✅ **Error Handling & Security Measures**  

## ⚙ **Setup Instructions**  

### 1️⃣ **Clone the Repository**  
```bash
git clone https://github.com/yourusername/Banking-Management-Systems-Using-JDBC.git
cd Banking-Management-Systems-Using-JDBC
```

### 2️⃣ **Set Up MySQL Database**  
1. **Create a Database**  
```sql
CREATE DATABASE BankingDB;
USE BankingDB;
```
2. **Create Required Tables**  
```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    balance DOUBLE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    amount DOUBLE,
    transaction_type ENUM('Deposit', 'Withdrawal'),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);
```

### 3️⃣ **Configure Database Connection**  
1. **Download MySQL JDBC Driver** from [MySQL Connector](https://dev.mysql.com/downloads/connector/j/).  
2. Add the **JAR file** to your project.  
3. Update `DatabaseConnection.java` with your database credentials:  
```java
String url = "jdbc:mysql://localhost:3306/BankingDB";
String user = "root";  // Your MySQL username
String password = "yourpassword";  // Your MySQL password
```

### 4️⃣ **Run the Application**  
1. Open the project in **Eclipse/IntelliJ**.  
2. Run the `Main.java` file.  
3. Follow the on-screen menu to use the banking features.  

## 🎯 **Usage**  
1. **Login or Sign Up**  
2. **Create an Account**  
3. **Deposit/Withdraw Money**  
4. **Check Balance & View Transactions**  

## 📌 **Future Enhancements**  
🚀 Implement a **GUI** using JavaFX or Swing  
🚀 Add **Admin Dashboard** for managing users  
🚀 Introduce **Online Fund Transfer** feature  
🚀 Encrypt passwords for better security  

## 🤝 **Contributing**  
Feel free to contribute by:  
🔹 **Forking** the repository  
🔹 **Opening Issues** for bugs/suggestions  
🔹 **Submitting Pull Requests**  
