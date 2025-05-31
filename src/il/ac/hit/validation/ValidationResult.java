package il.ac.hit.validation;

import java.util.Optional;

//public interface ValidationResult {
// boolean isValid();
// Optional<String> getReason();
//}
public interface ValidationResult {
    /**
     * Indicates whether the validation was successful.
     *
     * @return true if valid, false otherwise
     */
    boolean isValid();

    /**
     * Provides the reason for failure if not valid.
     *
     * @return an Optional containing the reason if invalid, or empty if valid
     */
    Optional<String> getReason();
}