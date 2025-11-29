import student.*;
import course.*;
import registration.*;
import admin.*;
import java.util.Scanner;

/**
 * Main class for the Course Registration System.
 * This is the entry point of the application that provides a menu-driven interface
 * for both students and administrators.
 *
 * Features:
 * - Student Portal: Registration, Login, Course Enrollment, Profile Management
 * - Admin Portal: Course Management, Student Management, Registration Monitoring
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentManager studentManager = new StudentManager();
    static CourseManager courseManager = new CourseManager();
    static RegistrationManager registrationManager = new RegistrationManager();
    static AdminManager adminManager = new AdminManager();
    static Student loggedInStudent = null;
    static Admin loggedInAdmin = null;

    /**
     * Main method - Entry point of the application.
     * Displays the main menu and handles user choices between Student and Admin portals.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("   COURSE REGISTRATION SYSTEM");
        System.out.println("========================================\n");

        while (true) {
            System.out.println("1. Student Portal");
            System.out.println("2. Admin Portal");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        studentPortal();
                        break;
                    case 2:
                        adminPortal();
                        break;
                    case 3:
                        System.out.println("\nThank you for using Course Registration System!");
                        System.exit(0);
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    // ==================== STUDENT PORTAL ====================

    /**
     * Student Portal - Main menu for student operations.
     * Provides options for registration, login, and navigation.
     */
    static void studentPortal() {
        while (true) {
            System.out.println("\n========== STUDENT PORTAL ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        studentRegister();
                        break;
                    case 2:
                        studentLogin();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    /**
     * Handles student registration.
     * Collects student information and creates a new student account.
     */
    static void studentRegister() {
        System.out.println("\n========== STUDENT REGISTRATION ==========");
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter password (min 6 characters): ");
        String password = sc.nextLine();

        String studentId = studentManager.generateStudentId();
        Student student = new Student(studentId, name, email, password);
        studentManager.registerStudent(student);
    }

    /**
     * Handles student login.
     * Authenticates student credentials and provides access to student dashboard.
     */
    static void studentLogin() {
        System.out.println("\n========== STUDENT LOGIN ==========");
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        loggedInStudent = studentManager.login(email, password);
        if (loggedInStudent != null) {
            System.out.println("Success: Login successful! Welcome " + loggedInStudent.getName());
            studentDashboard();
        } else {
            System.out.println("Error: Invalid email or password!");
        }
    }

    /**
     * Student Dashboard - Main menu after successful login.
     * Provides options for course viewing, enrollment, profile management, and logout.
     */
    static void studentDashboard() {
        while (loggedInStudent != null) {
            System.out.println("\n========== STUDENT DASHBOARD ==========");
            System.out.println("Welcome, " + loggedInStudent.getName());
            System.out.println("1. View Available Courses");
            System.out.println("2. Enroll in Course");
            System.out.println("3. View My Enrollments");
            System.out.println("4. Update Profile");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        courseManager.viewCourses();
                        break;
                    case 2:
                        enrollInCourse();
                        break;
                    case 3:
                        registrationManager.viewStudentRegistrations(loggedInStudent.getId());
                        break;
                    case 4:
                        updateStudentProfile();
                        break;
                    case 5:
                        loggedInStudent = null;
                        System.out.println("Success: Logged out successfully!\n");
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    /**
     * Handles course enrollment for the logged-in student.
     * Allows student to select and enroll in available courses.
     */
    static void enrollInCourse() {
        System.out.println("\n========== ENROLL IN COURSE ==========");
        courseManager.viewCourses();

        System.out.print("Enter course ID to enroll: ");
        String courseId = sc.nextLine().trim();

        Course course = courseManager.getCourseById(courseId);
        if (course != null) {
            registrationManager.registerStudentToCourse(loggedInStudent.getId(), courseId);
        } else {
            System.out.println("Error: Course not found!");
        }
    }

    /**
     * Handles student profile updates.
     * Allows student to update name and email.
     */
    static void updateStudentProfile() {
        System.out.println("\n========== UPDATE PROFILE ==========");
        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new email: ");
        String email = sc.nextLine().trim();

        studentManager.updateStudent(loggedInStudent.getId(), name, email);
        loggedInStudent = studentManager.getStudentById(loggedInStudent.getId());
    }

    // ==================== ADMIN PORTAL ====================

    /**
     * Admin Portal - Authentication and login for admin users.
     * Creates a default admin on first run.
     */
    static void adminPortal() {
        // Initialize default admin on first run
        if (!adminManager.hasAdmin()) {
            adminManager.addAdmin(new Admin("A-001", "admin", "admin123"));
            System.out.println("\n[System] Default admin created. Username: admin | Password: admin123\n");
        }

        System.out.println("\n========== ADMIN LOGIN ==========");
        System.out.print("Enter admin username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter admin password: ");
        String password = sc.nextLine();

        loggedInAdmin = adminManager.loginAdmin(username, password);
        if (loggedInAdmin != null) {
            System.out.println("Success: Admin login successful!");
            adminDashboard();
        } else {
            System.out.println("Error: Invalid username or password!");
        }
    }

    /**
     * Admin Dashboard - Main menu after successful admin login.
     * Provides options for managing courses, students, and registrations.
     */
    static void adminDashboard() {
        while (loggedInAdmin != null) {
            System.out.println("\n========== ADMIN DASHBOARD ==========");
            System.out.println("Welcome Admin!");
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Students");
            System.out.println("3. View All Registrations");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        manageCourses();
                        break;
                    case 2:
                        manageStudents();
                        break;
                    case 3:
                        registrationManager.viewRegistrations();
                        break;
                    case 4:
                        loggedInAdmin = null;
                        System.out.println("Success: Logged out successfully!\n");
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    /**
     * Course Management - Submenu for managing courses.
     * Provides options to add, view, update, and delete courses.
     */
    static void manageCourses() {
        while (true) {
            System.out.println("\n========== MANAGE COURSES ==========");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addCourse();
                        break;
                    case 2:
                        courseManager.viewCourses();
                        break;
                    case 3:
                        updateCourse();
                        break;
                    case 4:
                        deleteCourse();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    /**
     * Adds a new course to the system.
     * Collects course information and creates a new course entry.
     */
    static void addCourse() {
        System.out.println("\n========== ADD COURSE ==========");
        String courseId = courseManager.generateCourseId();

        System.out.print("Enter course name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter teacher name: ");
        String teacher = sc.nextLine().trim();

        System.out.print("Enter duration (e.g., 3 months): ");
        String duration = sc.nextLine().trim();

        System.out.print("Enter description: ");
        String description = sc.nextLine().trim();

        Course course = new Course(courseId, name, teacher, duration, description);
        courseManager.addCourse(course);
    }

    /**
     * Updates an existing course.
     * Allows admin to modify course information.
     */
    static void updateCourse() {
        System.out.println("\n========== UPDATE COURSE ==========");
        courseManager.viewCourses();

        System.out.print("Enter course ID to update: ");
        String courseId = sc.nextLine().trim();

        Course course = courseManager.getCourseById(courseId);
        if (course == null) {
            System.out.println("Error: Course not found!");
            return;
        }

        System.out.print("Enter new course name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new teacher name: ");
        String teacher = sc.nextLine().trim();

        System.out.print("Enter new duration: ");
        String duration = sc.nextLine().trim();

        System.out.print("Enter new description: ");
        String description = sc.nextLine().trim();

        courseManager.updateCourse(courseId, name, teacher, duration, description);
    }

    /**
     * Deletes a course from the system.
     * Allows admin to remove a course by ID.
     */
    static void deleteCourse() {
        System.out.println("\n========== DELETE COURSE ==========");
        courseManager.viewCourses();

        System.out.print("Enter course ID to delete: ");
        String courseId = sc.nextLine().trim();

        courseManager.removeCourse(courseId);
    }

    /**
     * Student Management - Submenu for managing students.
     * Provides options to view, update, and delete students.
     */
    static void manageStudents() {
        while (true) {
            System.out.println("\n========== MANAGE STUDENTS ==========");
            System.out.println("1. View All Students");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Back");
            System.out.print("Choose an option: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        studentManager.viewAllStudents();
                        break;
                    case 2:
                        updateStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Error: Invalid choice! Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.\n");
                sc.nextLine();
            }
        }
    }

    /**
     * Updates student information.
     * Allows admin to modify student name and email.
     */
    static void updateStudent() {
        System.out.println("\n========== UPDATE STUDENT ==========");
        studentManager.viewAllStudents();

        System.out.print("Enter student ID to update: ");
        String studentId = sc.nextLine().trim();

        Student student = studentManager.getStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        System.out.print("Enter new name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter new email: ");
        String email = sc.nextLine().trim();

        studentManager.updateStudent(studentId, name, email);
    }

    /**
     * Deletes a student from the system.
     * Allows admin to remove a student by ID.
     */
    static void deleteStudent() {
        System.out.println("\n========== DELETE STUDENT ==========");
        studentManager.viewAllStudents();

        System.out.print("Enter student ID to delete: ");
        String studentId = sc.nextLine().trim();

        studentManager.removeStudent(studentId);
    }
}