package registration;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Manages all registration operations in the Course Registration System.
 * This class handles student enrollments, enrollment queries, and registration deletion.
 */
public class RegistrationManager {
    private ArrayList<Registration> registrations = new ArrayList<>();
    private int regCounter = 0;

    /**
     * Generates a unique registration ID.
     * @return A new registration ID in format R-XXXX
     */
    public String generateRegistrationId() {
        regCounter++;
        return String.format("R-%04d", regCounter);
    }

    /**
     * Registers a student to a course.
     * Prevents duplicate enrollments for the same student-course pair.
     *
     * @param studentId The ID of the student
     * @param courseId The ID of the course
     */
    public void registerStudentToCourse(String studentId, String courseId) {
        // Check duplicate registration
        for (Registration r : registrations) {
            if (r.getStudentId().equals(studentId) && r.getCourseId().equals(courseId)) {
                System.out.println("Error: Student already enrolled in this course!");
                return;
            }
        }

        String regId = generateRegistrationId();
        Registration r = new Registration(regId, studentId, courseId, LocalDate.now());
        registrations.add(r);
        System.out.println("Success: Enrollment successful! Registration ID: " + regId);
    }

    /**
     * Displays all registrations in the system.
     */
    public void viewRegistrations() {
        if (registrations.isEmpty()) {
            System.out.println("Error: No registrations found.");
            return;
        }
        System.out.println("\n========== ALL REGISTRATIONS ==========");
        for (Registration r : registrations) {
            System.out.println(r);
        }
        System.out.println("========================================\n");
    }

    /**
     * Displays all registrations for a specific student.
     *
     * @param studentId The student ID to search for
     */
    public void viewStudentRegistrations(String studentId) {
        ArrayList<Registration> studentRegs = new ArrayList<>();
        for (Registration r : registrations) {
            if (r.getStudentId().equals(studentId)) {
                studentRegs.add(r);
            }
        }

        if (studentRegs.isEmpty()) {
            System.out.println("Error: No registrations found for this student.");
            return;
        }

        System.out.println("\n===== Student's Registrations =====");
        for (Registration r : studentRegs) {
            System.out.println(r);
        }
        System.out.println("===================================\n");
    }

    /**
     * Removes a registration from the system.
     *
     * @param registrationId The registration ID to remove
     */
    public void removeRegistration(String registrationId) {
        for (Registration r : registrations) {
            if (r.getId().equals(registrationId)) {
                registrations.remove(r);
                System.out.println("Success: Registration removed successfully!");
                return;
            }
        }
        System.out.println("Error: Registration not found!");
    }
}