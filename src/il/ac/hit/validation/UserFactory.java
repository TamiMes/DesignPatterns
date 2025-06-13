package il.ac.hit.validation;

/**
 * Factory class for creating instances of {@link User} subclasses.
 * Supports creation of BasicUser, PremiumUser, and PlatinumUser.
 */
public class UserFactory {
 
    /**
     * Creates a specific type of user based on the provided type string.
     *
     * @param type the type of user ("basic", "premium", or "platinum")
     * @param username the username for the user
     * @param email the email address for the user
     * @param password the password for the user
     * @param age the age of the user
     * @return a new instance of {@link User} subclass
     * @throws IllegalArgumentException if the type is unknown or invalid
     */
    public static User createUser(String type, String username, String email, String password, int age) {
        // === Argument Validation ===
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("User type cannot be null or empty");
        }

        // === Convert type to lowercase and create appropriate user ===
        switch (type.toLowerCase()) {
            // Creating a BasicUser
            case "basic":
                return new BasicUser(username, email, password, age);

            // Creating a PremiumUser
            case "premium":
                return new PremiumUser(username, email, password, age);

            // Creating a PlatinumUser
            case "platinum":
                return new PlatinumUser(username, email, password, age);

            // Unknown user type
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}
