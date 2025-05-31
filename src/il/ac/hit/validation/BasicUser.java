package il.ac.hit.validation;

/**
 * Represents a basic type of user in the system.
 * Extends the {@link User} class.
 */
public class BasicUser extends User {

    /**
     * Primary constructor for BasicUser.
     * Creates a new BasicUser with the specified parameters.
     *
     * @param username the user's name
     * @param email    the user's email
     * @param password the user's password
     * @param age      the user's age
     */
    public BasicUser(String username, String email, String password, int age) {
        super(username, email, password, age);
    }

    /**
     * Returns a string representation of this BasicUser.
     * @return string representation including user type and basic info
     */
    @Override
    public String toString() {
        return "BasicUser{" + super.toString() + "}";
    }
}