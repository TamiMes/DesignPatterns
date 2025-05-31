package il.ac.hit.validation;

/**
 * Represents a premium user in the system.
 * Extends the {@link User} class and inherits all of its behavior.
 * Premium users may be given additional privileges in the future.
 */
public class PremiumUser extends User {

    /**
     * Constructs a new {@code PremiumUser} with the specified details.
     * Delegates initialization to the {@link User} constructor.
     *
     * @param username the username for the premium user
     * @param email the email address for the premium user
     * @param password the password for the premium user
     * @param age the age of the premium user
     */
    public PremiumUser(String username, String email, String password, int age) {
        super(username, email, password, age);
    }


}
