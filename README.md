# 📚 Library Management System

A desktop-based **Library Management System** developed using **Java Swing** following the **MVC (Model–View–Controller)** architectural pattern.  
This application helps manage books and book issue/return operations efficiently.

---

## 🚀 Features

- Add, delete, and view books
- Issue and return books
- Track issued books and availability status
- User-friendly GUI using Java Swing
- Clean separation of concerns using MVC architecture

---

## 🛠️ Technologies Used

- **Java (JDK 8+)**
- **Java Swing** (GUI)
- **MVC Architecture**

## 🗂️ Data Storage

This project does not use a database.
All data is managed using in-memory Java collections (ArrayList) / file-based storage.
This approach keeps the project simple and focused on MVC architecture and Swing UI.

---

## 🧩 Project Architecture (MVC)

```text
src/
├── model/
│   ├── Book.java
│   └── BookModel.java
│
├── view/
│   └── LibraryView.java
│
├── controller/
│   └── BookController.java
│
└── main/
    └── LibraryApp.java
