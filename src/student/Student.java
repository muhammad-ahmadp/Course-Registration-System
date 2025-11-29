package student;

/**
 * Represents a student in the Course Registration System.
 * This class stores student information including ID, name, email, and password.
 */
public class Student {
    private String id;
    private String name;
    private String email;
    private String password;

    /**
     * Constructor to create a new Student object.
     *
     * @param id The unique identifier for the student
     * @param name The full name of the student
     * @param email The email address of the student
     * @param password The password for student login
     */
    public Student(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the student ID.
     * @return The student ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the student name.
     * @return The student name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the student email.
     * @return The student email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the student password.
     * @return The student password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the student name.
     * @param name The new name for the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the student email.
     * @param email The new email for the student
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the student password.
     * @param password The new password for the student
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the student.
     * @return A formatted string with student information
     */
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s", id, name, email);
    }
}