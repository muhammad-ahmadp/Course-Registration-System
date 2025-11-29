package course;

/**
 * Represents a course in the Course Registration System.
 * This class stores course information including ID, name, teacher, duration, and description.
 */
public class Course {
    private String id;
    private String name;
    private String teacher;
    private String duration;
    private String description;

    /**
     * Constructor to create a new Course object.
     *
     * @param id The unique identifier for the course
     * @param name The name of the course
     * @param teacher The name of the course instructor
     * @param duration The duration of the course (e.g., "3 months")
     * @param description A brief description of the course
     */
    public Course(String id, String name, String teacher, String duration, String description) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.duration = duration;
        this.description = description;
    }

    /**
     * Gets the course ID.
     * @return The course ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the course name.
     * @return The course name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the course teacher.
     * @return The teacher name
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Gets the course duration.
     * @return The course duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Gets the course description.
     * @return The course description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the course name.
     * @param name The new course name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the course teacher.
     * @param teacher The new teacher name
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Sets the course duration.
     * @param duration The new course duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Sets the course description.
     * @param description The new course description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the course.
     * @return A formatted string with course information
     */
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Teacher: %s | Duration: %s | Description: %s",
                id, name, teacher, duration, description);
    }
}
