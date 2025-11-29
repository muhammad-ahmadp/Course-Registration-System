package admin;

import java.util.ArrayList;

/**
 * Manages all admin operations in the Course Registration System.
 * This class handles admin registration, authentication, and management.
 */
public class AdminManager {
    private ArrayList<Admin> admins = new ArrayList<>();

    /**
     * Checks if any admin exists in the system.
     * @return true if at least one admin exists, false otherwise
     */
    public boolean hasAdmin() {
        return !admins.isEmpty();
    }

    /**
     * Adds a new admin to the system.
     * Prevents duplicate admin usernames.
     *
     * @param admin The admin object to add
     */
    public void addAdmin(Admin admin) {
        for (Admin a : admins) {
            if (a.getName().equals(admin.getName())) {
                System.out.println("Error: Admin already exists!");
                return;
            }
        }
        admins.add(admin);
        System.out.println("Success: Admin added successfully!");
    }

    /**
     * Authenticates admin login credentials.
     *
     * @param name The admin username
     * @param password The admin password
     * @return The Admin object if credentials are valid, null otherwise
     */
    public Admin loginAdmin(String name, String password) {
        for (Admin a : admins) {
            if (a.getName().equals(name) && a.getPassword().equals(password)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Displays all admins in the system.
     */
    public void viewAllAdmins() {
        if (admins.isEmpty()) {
            System.out.println("Error: No admins found.");
            return;
        }
        System.out.println("\n========== ALL ADMINS ==========");
        for (Admin a : admins) {
            System.out.println("ID: " + a.getId() + " | Name: " + a.getName());
        }
        System.out.println("================================\n");
    }

    /**
     * Retrieves an admin by ID.
     *
     * @param id The admin ID to search for
     * @return The Admin object if found, null otherwise
     */
    public Admin getAdminById(String id) {
        for (Admin a : admins) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Removes an admin from the system.
     *
     * @param id The admin ID to remove
     */
    public void removeAdmin(String id) {
        for (Admin a : admins) {
            if (a.getId().equals(id)) {
                admins.remove(a);
                System.out.println("Success: Admin removed successfully!");
                return;
            }
        }
        System.out.println("Error: Admin not found!");
    }
}