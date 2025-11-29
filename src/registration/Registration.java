package registration;

import java.time.LocalDate;

/**
 * Represents a course registration (enrollment) in the Course Registration System.
 * This class stores information about a student's enrollment in a course.
 */
public class Registration {
    private String id;
    private String studentId;
    private String courseId;
    private LocalDate date;

    /**
     * Constructor to create a new Registration object.
     *
     * @param id The unique identifier for the registration
     * @param studentId The ID of the student
     * @param courseId The ID of the course
     * @param date The date of enrollment
     */
    public Registration(String id, String studentId, String courseId, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    /**
     * Gets the registration ID.
     * @return The registration ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the student ID.
     * @return The student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Gets the course ID.
     * @return The course ID
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Gets the enrollment date.
     * @return The enrollment date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns a string representation of the registration.
     * @return A formatted string with registration information
     */
    @Override
    public String toString() {
        return String.format("RegID: %s | StudentID: %s | CourseID: %s | Date: %s",
                id, studentId, courseId, date);
    }
}