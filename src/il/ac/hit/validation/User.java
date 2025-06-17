package il.ac.hit.validation;

/**
 * Represents a generic user in the system.
 * Holds basic account information including username, email, password, and age.
 */
public class User {

    // ================== Fields ==================
    private String username;
    private String email;
    private String password;
    private int age;

    // ================== Constructor ==================

    /**
     * Constructs a new {@code User} with the specified details.
     * All parameters are validated through their respective setters.
     *
     * @param username the user's username
     * @param email the user's email
     * @param password the user's password
     * @param age the user's age
     */
    public User(String username, String email, String password, int age) {
        // Delegating to setters for validation
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setAge(age);
    }

    // ================== Getters ==================

    /**
     * Gets the username.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the age.
     * @return the age
     */
    public int getAge() {
        return age;
    }

    // ================== Setters ==================

    /**
     * Sets the username. Must not be null or empty.
     * @param username the username to set
     * @throws IllegalArgumentException if the username is invalid
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    /**
     * Sets the email. Must not be null or empty.
     * @param email the email to set
     * @throws IllegalArgumentException if the email is invalid
     */
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }

    /**
     * Sets the password. Must not be null or empty.
     * @param password the password to set
     * @throws IllegalArgumentException if the password is invalid
     */
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.password = password;
    }

    /**
     * Sets the age. Must be a positive number.
     * @param age the age to set
     * @throws IllegalArgumentException if the age is invalid
     */
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age;
    }
}


