package il.ac.hit.validation;

/**
 * Represents a platinum tier user in the system with premium privileges.
 * Extends the {@link User} class to provide enhanced user functionality.
 */
public class PlatinumUser extends User {

    /**
     * Primary constructor for PlatinumUser.
     * Creates a new PlatinumUser with the specified parameters.
     *
     * @param username the user's name
     * @param email    the user's email
     * @param password the user's password
     * @param age      the user's age
     */
    public PlatinumUser(String username, String email, String password, int age) {
        super(username, email, password, age);
    }

    /**
     * Returns a string representation of this PlatinumUser.
     * @return string representation including user type and basic info
     */
    @Override
    public String toString() {
        return "PlatinumUser{" + super.toString() + "}";
    }
}