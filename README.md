# 📱 Student Database Management Android App

An Android application developed using **Kotlin and XML** that provides user registration, login authentication, and student record management using SQLite Database.

This project demonstrates Android concepts like Activity Navigation, SQLite Database CRUD operations, custom UI designing, and dialog implementation.

---

## 🚀 Features

## 🔐 User Registration

- Users can create an account by entering:
  - Username
  - Email
  - Password

- Registration details are stored in SQLite Database.
- Shows successful registration message after submitting the form.

---

## 🔑 Login Authentication

- User login with username and password.
- Login credentials are verified from SQLite Database.
- Incorrect username or password prevents login.
- Only registered users can access the Student Database page.

---

# 📚 Student Database Management

After successful login, user can manage stored records.

Features:

## 📖 View Data

- Displays saved user/student records.
- Uses custom popup dialog to show database records.

---

## ✏️ Update Data

- Allows updating existing records.
- User can modify stored information.

---

## 🗑️ Delete Data

- Deletes selected records permanently from SQLite Database.

---

# 🛠️ Technologies Used

- Kotlin
- XML
- Android Studio
- SQLite Database
- Android Activities
- Intent Navigation
- Custom Dialog Box

---

# 📂 Project Structure

```
app

├── java/com.example.myapplication5

│
├── Registration_Pagee.kt
├── LoginActivity.kt
├── Page_2.kt
└── DBHelper.kt


res/layout

├── activity_registration_pagee.xml
├── activity_login.xml
├── activity_page2.xml
├── dialog_student_records.xml
```

---

# 🗄️ Database

SQLite Database is used for storing and managing user information.

Database Operations:

✔ Insert Data  
✔ View Data  
✔ Update Data  
✔ Delete Data  
✔ Login Verification  

---

# 📱 Application Flow


Registration Page

↓

User Details Stored in SQLite Database

↓

Login Page

↓

Authentication Check

↓

Student Database Dashboard

↓

View / Update / Delete Records


---

# ▶️ How to Run

1. Clone the repository

```bash
git clone repository-link
```

2. Open the project in Android Studio.

3. Sync Gradle files.

4. Run on Emulator or Android Device.

---

# 📚 Learning Outcomes

This project helped to understand:

- Android Activity Lifecycle
- Kotlin Programming
- XML UI Designing
- Intent Navigation
- SQLite Database Connectivity
- CRUD Operations
- Login Authentication

---

# 👨‍💻 Developer

Aryan Raj

BCA Student  
Android App Development Project
