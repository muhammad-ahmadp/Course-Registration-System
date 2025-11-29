# Course Registration System

A comprehensive console-based platform for managing student course enrollments with dual portals for students and administrators. This project demonstrates the implementation of role-based access control, object-oriented design, and robust data validation.

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## 1. Overview

The Course Registration System provides a complete solution for educational institutions to manage student enrollments, course offerings, and registrations. The system's core value lies in its ability to enforce academic integrity by preventing duplicate enrollments and maintaining a clear audit trail of all registrations.

### Core Features

*   **Student Registration:** Self-service account creation with email validation and password security.
*   **Student Authentication:** Secure login system with email and password credentials.
*   **Course Management:** Complete CRUD operations for managing course offerings and details.
*   **Course Enrollment:** Students can browse and enroll in available courses.
*   **Enrollment Tracking:** View all course enrollments with automatic date recording.
*   **Profile Management:** Students can update their name and email information.
*   **Admin Portal:** Administrative control over courses, students, and registrations.
*   **Duplicate Prevention:** Prevents duplicate course enrollments and user registrations.
*   **Role-Based Access:** Separate portals and functionality for students and administrators.

---

## 2. Technical Architecture

The system is built on core Java principles with a modular package-based architecture, ensuring clean code organization and maintainability.

### Key Technical Components

| Component | Role | Key Concepts Demonstrated |
| :--- | :--- | :--- |
| **Java** | Core programming language | Object-Oriented Programming (OOP) |
| **ArrayList** | Data storage and management | Dynamic Collections, Data Structures |
| **LocalDate API** | Date tracking for enrollments | Modern Java Date/Time API |
| **Exception Handling** | Error management and recovery | Input Validation, Graceful Error Handling |
| **Package Organization** | Code structure and modularity | Separation of Concerns, Clean Architecture |

### Design Decisions

The design focuses on providing a scalable, maintainable system with clear separation of concerns.

*   **Package-Based Architecture:** Each functional area (student, course, registration, admin) has its own package containing entity and manager classes.
*   **Manager Pattern:** Each entity type has a corresponding manager class handling business logic and data operations.
*   **Input Validation:** Comprehensive validation ensures data integrity throughout the system.
*   **Auto-Generated IDs:** Professional ID generation for students (S-2025-XXX), courses (C-XXXX), registrations (R-XXXX), and admins (A-XXX).

### Code Example: Student Registration Logic

The system validates student information before registration:

```
Enter name: Muhammad Ahmad
Enter email: ahmad@example.com
Enter password: password123
Success: Registration successful! Your ID: S-2025-001
```

---

## 3. Project Structure

```
Course-Registration-System/
├── student/
│   ├── Student.java
│   └── StudentManager.java
├── course/
│   ├── Course.java
│   └── CourseManager.java
├── registration/
│   ├── Registration.java
│   └── RegistrationManager.java
├── admin/
│   ├── Admin.java
│   └── AdminManager.java
├── Main.java
└── README.md
```

### Package Descriptions

*   **student:** Manages student entity and all student-related operations including registration, authentication, and profile management.
*   **course:** Handles course entity and course management operations including creation, updates, and deletion.
*   **registration:** Manages course registration (enrollment) records with automatic date tracking.
*   **admin:** Handles admin authentication and admin user management.
*   **Main.java:** Application entry point with menu-driven interface for both student and admin portals.

---

## 4. How to Run

### Prerequisites
*   Java Development Kit (JDK) 8 or higher

### Installation and Execution

1.  Ensure all Java files are in the correct package structure as shown above.

2.  Compile all files:
    ```bash
    javac student/*.java course/*.java registration/*.java admin/*.java Main.java
    ```

3.  Run the application:
    ```bash
    java Main
    ```

### Sample Usage Flow

**Student Registration:**
```
========== STUDENT REGISTRATION ==========
Enter name: Muhammad Ahmad
Enter email: ahmad@university.edu
Enter password (min 6 characters): password123
Success: Registration successful! Your ID: S-2025-001
```

**Student Login:**
```
========== STUDENT LOGIN ==========
Enter email: ahmad@university.edu
Enter password: password123
Success: Login successful! Welcome Muhammad Ahmad
```

**Admin Login:**
```
========== ADMIN LOGIN ==========
Enter admin username: admin
Enter admin password: admin123
Success: Admin login successful!
```

**Default Admin Credentials:**
```
Username: admin
Password: admin123
```

---

## 5. Key Features Explained

### Student Portal

The student portal provides a complete self-service experience:

*   **Registration:** Create account with email and password validation.
*   **Login:** Secure authentication with email and password.
*   **Course Browsing:** View all available courses with complete details.
*   **Course Enrollment:** Enroll in courses with automatic duplicate prevention.
*   **Enrollment Tracking:** View all enrolled courses with enrollment dates.
*   **Profile Management:** Update name and email address.

### Admin Portal

The admin portal provides complete system management capabilities:

*   **Course Management:** Add, view, update, and delete courses.
*   **Student Management:** View all students, update student information, and remove students.
*   **Registration Monitoring:** View all course registrations across the system.
*   **User Management:** View and manage admin accounts.

### Validation Features

The system implements comprehensive validation:

*   **Email Validation:** Must contain @ symbol and domain extension.
*   **Password Validation:** Minimum 6 characters required.
*   **Duplicate Prevention:** Prevents duplicate student emails and course enrollments.
*   **ID Uniqueness:** Auto-generated IDs ensure uniqueness and prevent conflicts.

---

## 6. Technical Details

### Data Persistence

Currently, the system stores all data in memory using ArrayList collections:

*   **Student Data:** Stored in StudentManager with ArrayList of Student objects.
*   **Course Data:** Stored in CourseManager with ArrayList of Course objects.
*   **Registration Data:** Stored in RegistrationManager with ArrayList of Registration objects.
*   **Admin Data:** Stored in AdminManager with ArrayList of Admin objects.

### Exception Handling

The application implements robust exception handling:

```
try {
    int choice = sc.nextInt();
    sc.nextLine();
    // Process choice
} catch (Exception e) {
    System.out.println("Error: Please enter a valid number.");
    sc.nextLine();
}
```

### Date Tracking

Enrollments are automatically tracked with current date using LocalDate API:

```
LocalDate date = LocalDate.now();
```

---

## 7. Limitations and Future Enhancements

### Known Limitations

*   **Data Persistence:** Data is stored in memory only and is lost upon application exit.
*   **Interface:** Limited to console-based interface.
*   **Storage:** No database backend for data storage.
*   **Scalability:** Current implementation uses ArrayList which may not be optimal for very large datasets.

### Future Enhancements

*   Implement database persistence using JDBC or JPA (Java Persistence API).
*   Develop a Graphical User Interface (GUI) using JavaFX or Swing.
*   Add user authentication with encrypted passwords.
*   Implement multi-session support for concurrent users.
*   Add advanced reporting features with enrollment statistics.
*   Implement file-based backup and restore functionality.
*   Add unit tests for all critical business logic.
*   Create REST API for integration with other systems.

---

## 8. Object-Oriented Principles Demonstrated

### Encapsulation

All class attributes are private with public getter and setter methods:

```
private String id;
private String name;
private String email;

public String getId() { return id; }
public void setName(String name) { this.name = name; }
```

### Inheritance and Polymorphism

Manager classes follow a similar pattern for consistent behavior across different entity types.

### Abstraction

Business logic is abstracted into manager classes, hiding complexity from the main application logic.

### Single Responsibility Principle

Each class has a single, well-defined responsibility:

*   Student class represents student data.
*   StudentManager handles student operations.
*   Admin class represents admin data.
*   AdminManager handles admin operations.

---

## 9. Code Quality and Documentation

### Javadoc Documentation

All classes and methods include comprehensive Javadoc comments:

```
/**
 * Registers a new student in the system.
 * Validates email and password, and checks for duplicates.
 * 
 * @param student The student object to register
 */
public void registerStudent(Student student) {
    // Implementation
}
```

### Naming Conventions

Clear and descriptive naming following Java conventions:

*   Classes: PascalCase (Student, StudentManager)
*   Methods: camelCase (registerStudent, viewAllStudents)
*   Constants: UPPER_SNAKE_CASE
*   Variables: camelCase (studentId, studentName)

### Error Messages

Consistent error message format for better user experience:

```
Error: Invalid email format! Must contain @ and .
Success: Registration successful! Your ID: S-2025-001
```

---

## 10. Contact and License

### Author

Muhammad Ahmad

*   GitHub: [@muhammad-ahmadp](https://github.com/muhammad-ahmadp)
*   LinkedIn: [muhammad-ahmadcs](https://linkedin.com/in/muhammad-ahmadcs)

### License

This project is licensed under the MIT License. See the LICENSE file for details.

### Acknowledgments

This project demonstrates the practical application of Object-Oriented Programming principles, role-based access control, and comprehensive system design in Java.
