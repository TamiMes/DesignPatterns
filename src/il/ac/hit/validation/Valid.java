package il.ac.hit.validation;

import java.util.Optional;

/**
 * Represents a successful validation result.
 * This class is immutable and stateless.
 */
public class Valid implements ValidationResult {

    /**
     * Returns {@code true} as this represents a valid result.
     *
     * @return {@code true} always
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Returns an empty {@link Optional} since there is no reason for valid results.
     *
     * @return an empty Optional
     */
    @Override
    public Optional<String> getReason() {
        return Optional.empty();
    }
}
