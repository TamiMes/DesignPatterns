package il.ac.hit.validation;

import java.util.Optional;

/**
 * Represents an invalid validation result with a specific reason for the failure.
 * This class implements ValidationResult to indicate that validation has failed.
 */
public class Invalid implements ValidationResult {
    private final String reason;

    /**
     * Constructs an Invalid validation result with the specified reason.
     * @param reason the reason why validation failed, must not be null or empty
     * @throws IllegalArgumentException if reason is null or empty
     */
    public Invalid(String reason) {
        setReason(reason);
        this.reason = reason;
    }

    /**
     * Validates the reason parameter.
     * @param reason the reason to validate
     * @throws IllegalArgumentException if reason is null or empty
     */
    private void setReason(String reason) {
        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("Reason cannot be null or empty");
        }
    }

    /**
     * Returns false as this represents an invalid validation result.
     * @return false indicating validation failure
     */
    @Override
    public boolean isValid() {
        return false;
    }

    /**
     * Returns the reason for validation failure.
     * @return Optional containing the reason for validation failure
     */
    @Override
    public Optional<String> getReason() {
        return Optional.of(reason);
    }
}