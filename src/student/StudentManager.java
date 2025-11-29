package student;

import java.util.ArrayList;

/**
 * Manages all student operations in the Course Registration System.
 * This class handles student registration, login, updates, and deletion.
 */
public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private static int studentCounter = 0;

    /**
     * Generates a unique student ID.
     * @return A new student ID in format S-2025-XXX
     */
    public String generateStudentId() {
        studentCounter++;
        return String.format("S-2025-%03d", studentCounter);
    }

    /**
     * Validates email format.
     * Checks if email contains @ and . and is not empty.
     *
     * @param email The email to validate
     * @return true if email is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".") && !email.isEmpty();
    }

    /**
     * Validates password strength.
     * Password must be at least 6 characters long.
     *
     * @param password The password to validate
     * @return true if password is valid, false otherwise
     */
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    /**
     * Registers a new student in the system.
     * Validates email and password, and checks for duplicates.
     *
     * @param student The student object to register
     */
    public void registerStudent(Student student) {
        // Email validation
        if (!isValidEmail(student.getEmail())) {
            System.out.println("Error: Invalid email format! Must contain @ and .");
            return;
        }

        // Password validation
        if (!isValidPassword(student.getPassword())) {
            System.out.println("Error: Password must be at least 6 characters long!");
            return;
        }

        // Duplicate check
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(student.getEmail())) {
                System.out.println("Error: Student with this email already exists!");
                return;
            }
        }
        students.add(student);
        System.out.println("Success: Registration successful! Your ID: " + student.getId());
    }

    /**
     * Authenticates student login credentials.
     *
     * @param email The student email
     * @param password The student password
     * @return The Student object if credentials are valid, null otherwise
     */
    public Student login(String email, String password) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Displays all students in the system.
     */
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Error: No students found.");
            return;
        }
        System.out.println("\n========== ALL STUDENTS ==========");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("==================================\n");
    }

    /**
     * Retrieves a student by ID.
     *
     * @param id The student ID to search for
     * @return The Student object if found, null otherwise
     */
    public Student getStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Updates student information.
     * Validates new email and checks for duplicates.
     *
     * @param id The student ID to update
     * @param name The new name
     * @param email The new email
     */
    public void updateStudent(String id, String name, String email) {
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return;
        }

        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email format!");
            return;
        }

        // Check if email already exists (excluding current student)
        for (Student s : students) {
            if (!s.getId().equals(id) && s.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Error: Email already in use!");
                return;
            }
        }

        student.setName(name);
        student.setEmail(email);
        System.out.println("Success: Student updated successfully!");
    }

    /**
     * Removes a student from the system.
     *
     * @param id The student ID to remove
     */
    public void removeStudent(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                System.out.println("Success: Student removed successfully!");
                return;
            }
        }
        System.out.println("Error: Student not found!");
    }
}