package course;

import java.util.ArrayList;

/**
 * Manages all course operations in the Course Registration System.
 * This class handles course creation, updates, deletion, and retrieval.
 */
public class CourseManager {
    private ArrayList<Course> courses = new ArrayList<>();
    private static int courseCounter = 1000;

    /**
     * Generates a unique course ID.
     * @return A new course ID in format C-XXXX
     */
    public String generateCourseId() {
        courseCounter++;
        return "C-" + courseCounter;
    }

    /**
     * Adds a new course to the system.
     * Checks for duplicate course names before adding.
     *
     * @param course The course object to add
     */
    public void addCourse(Course course) {
        for (Course c : courses) {
            if (c.getName().equalsIgnoreCase(course.getName())) {
                System.out.println("Error: Course already exists!");
                return;
            }
        }
        courses.add(course);
        System.out.println("Success: Course added successfully! ID: " + course.getId());
    }

    /**
     * Displays all courses in the system.
     */
    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("Error: No courses available.");
            return;
        }
        System.out.println("\n========== ALL COURSES ==========");
        for (Course c : courses) {
            System.out.println(c);
        }
        System.out.println("=================================\n");
    }

    /**
     * Retrieves a course by ID.
     *
     * @param id The course ID to search for
     * @return The Course object if found, null otherwise
     */
    public Course getCourseById(String id) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Updates course information.
     *
     * @param id The course ID to update
     * @param name The new course name
     * @param teacher The new teacher name
     * @param duration The new course duration
     * @param description The new course description
     */
    public void updateCourse(String id, String name, String teacher, String duration, String description) {
        Course course = getCourseById(id);
        if (course == null) {
            System.out.println("Error: Course not found!");
            return;
        }

        course.setName(name);
        course.setTeacher(teacher);
        course.setDuration(duration);
        course.setDescription(description);
        System.out.println("Success: Course updated successfully!");
    }

    /**
     * Removes a course from the system.
     *
     * @param id The course ID to remove
     */
    public void removeCourse(String id) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                courses.remove(c);
                System.out.println("Success: Course removed successfully!");
                return;
            }
        }
        System.out.println("Error: Course not found!");
    }
}
