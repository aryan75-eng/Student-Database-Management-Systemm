# 📱 Student Database Management Android App (Firebase)

An Android application developed using **Kotlin and XML** that provides user registration, login authentication, and student record management using **Firebase Realtime Database**.

This project demonstrates Android concepts like Activity Navigation, Firebase integration, cloud database operations, custom UI designing, and CRUD functionality.

---

## 🚀 Features

## 🔐 User Registration

- Users can create an account by entering:
  - Username
  - Email
  - Password

- Registration details are stored in Firebase Realtime Database.
- Provides real-time cloud data storage.
- Shows successful registration message after submitting the form.

---

## 🔑 Login Authentication

- User login using username and password.
- Login details are verified from stored database records.
- Incorrect credentials prevent unauthorized access.
- Successfully logged-in users can access the Student Database Dashboard.

---

# 📚 Student Database Management

After successful login, users can manage student records.

Features:

---

## ➕ Insert Data

- Add new student information.
- Data gets stored securely in Firebase Realtime Database.

---

## 📖 View Data

- Retrieve and display stored student records.
- Fetches real-time data from Firebase.

---

## ✏️ Update Data

- Allows updating existing student information.
- Modified data is updated directly in Firebase Database.

---

## 🗑️ Delete Data

- Removes selected student records permanently from Firebase Realtime Database.

---

# 🔥 Firebase Integration

Firebase Realtime Database is used for storing and managing application data.

Firebase provides:

✔ Cloud Database Storage  
✔ Real-time Data Synchronization  
✔ Online Data Access  
✔ Secure Data Management  

---

# 🛠️ Technologies Used

- Kotlin
- XML
- Android Studio
- Firebase Realtime Database
- Firebase Console
- Android Activities
- Intent Navigation
- Material Design Components

---

# 📂 Project Structure

```
app

├── java/com.example.myapplication5

│
├── Registration_Pagee.kt
├── LoginActivity.kt
├── PageActivity2.kt
└── google-services.json


res/layout

├── activity_registration_pagee.xml
├── activity_login.xml
├── activity_page2.xml
```

---

# 🗄️ Database Structure

Firebase Realtime Database stores data in JSON format.

Example:

```
Users

 └── Username

      ├── username : Aryan
      ├── email : aryan@gmail.com
      └── password : 12345
```

---

# 📱 Application Flow


Registration Page

↓

User Details Stored in Firebase Realtime Database

↓

Login Page

↓

Authentication Verification

↓

Student Database Dashboard

↓

Insert / View / Update / Delete Records


---

# ▶️ How to Run

1. Clone the repository

```bash
git clone repository-link
```

2. Open the project in Android Studio.

3. Connect project with Firebase.

4. Add google-services.json file.

5. Sync Gradle files.

6. Run the application on Emulator or Android Device.

---

# 📚 Learning Outcomes

This project helped to understand:

- Android App Development
- Kotlin Programming
- XML UI Designing
- Firebase Integration
- Firebase Realtime Database
- Cloud Database Connectivity
- CRUD Operations
- Activity Navigation
- Gradle Configuration

---

# 👨‍💻 Developer

Aryan Raj

BCA Student  
Android App Development Project
