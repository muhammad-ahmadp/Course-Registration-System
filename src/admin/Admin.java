package admin;

/**
 * Represents an admin user in the Course Registration System.
 * This class stores admin information including ID, username, and password.
 */
public class Admin {
    private String id;
    private String name;
    private String password;

    /**
     * Constructor to create a new Admin object.
     *
     * @param id The unique identifier for the admin
     * @param name The admin username
     * @param password The admin password
     */
    public Admin(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Gets the admin ID.
     * @return The admin ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the admin username.
     * @return The admin username
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the admin password.
     * @return The admin password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the admin username.
     * @param name The new admin username
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the admin password.
     * @param password The new admin password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}