package il.ac.hit.validation;

import java.util.function.Function;

/**
 * A combinator-based functional interface for validating {@link User} objects.
 * <p>
 * Supports composing multiple validation rules using logical operations such as AND, OR, XOR.
 * Includes common validations as static factory methods.
 * <p>
 * This interface extends {@link Function} with input {@link User} and output {@link ValidationResult}.
 */
@FunctionalInterface
public interface UserValidation extends Function<User, ValidationResult> {

    /**
     * Combines this validation with another validation using logical AND.
     * Both validations must pass for the result to be valid.
     *
     * @param other the other validation to combine with
     * @return a composed validation representing the logical AND
     */
    default UserValidation and(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    /**
     * Combines this validation with another validation using logical OR.
     * At least one validation must pass for the result to be valid.
     *
     * @param other the other validation to combine with
     * @return a composed validation representing the logical OR
     */
    default UserValidation or(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? result : other.apply(user);
        };
    }

    /**
     * Combines this validation with another validation using logical XOR.
     * Exactly one of the validations must pass for the result to be valid.
     *
     * @param other the other validation to combine with
     * @return a composed validation representing the logical XOR
     */
    default UserValidation xor(UserValidation other) {
        return user -> {
            boolean first = this.apply(user).isValid();
            boolean second = other.apply(user).isValid();
            if (first ^ second) {
                return new Valid();
            } else {
                return new Invalid("XOR validation failed: both are either valid or invalid");
            }
        };
    }

    /**
     * Creates a validation that requires all provided validations to pass.
     *
     * @param validations array of validations to be checked
     * @return a validation that passes only if all validations pass
     * @throws IllegalArgumentException if validations array is null or empty
     */
    static UserValidation all(UserValidation... validations) {
        if (validations == null || validations.length == 0) {
            throw new IllegalArgumentException("Validations array cannot be null or empty");
        }

        return user -> {
            for (UserValidation validation : validations) {
                ValidationResult result = validation.apply(user);
                if (!result.isValid()) {
                    return result; // return first failure
                }
            }
            return new Valid();
        };
    }

    /**
     * Creates a validation that requires none of the provided validations to pass.
     *
     * @param validations array of validations to be checked
     * @return a validation that passes only if none of the validations pass
     * @throws IllegalArgumentException if validations array is null or empty
     */
    static UserValidation none(UserValidation... validations) {
        if (validations == null || validations.length == 0) {
            throw new IllegalArgumentException("Validations array cannot be null or empty");
        }

        return user -> {
            for (UserValidation validation : validations) {
                if (validation.apply(user).isValid()) {
                    return new Invalid("At least one validation passed when none should");
                }
            }
            return new Valid();
        };
    }

    // ==== Common User Validations ====

    /** Email must end with "il". */
    static UserValidation emailEndsWithIL() {
        return user -> user.getEmail().endsWith("il")
                ? new Valid()
                : new Invalid("Email must end with 'il'");
    }

    /** Email length must be greater than 10 characters. */
    static UserValidation emailLengthBiggerThan10() {
        return user -> user.getEmail().length() > 10
                ? new Valid()
                : new Invalid("Email must be longer than 10 characters");
    }

    /** Password length must be greater than 8 characters. */
    static UserValidation passwordLengthBiggerThan8() {
        return user -> user.getPassword().length() > 8
                ? new Valid()
                : new Invalid("Password must be longer than 8 characters");
    }

    /**
     * Password must include only letters and numbers.
     * Returns invalid on first non-letter-or-digit character.
     */
    static UserValidation passwordIncludesLettersNumbersOnly() {
        return user -> {
            String password = user.getPassword();
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (!Character.isLetterOrDigit(c)) {
                    return new Invalid("Password must include only letters and numbers");
                }
            }
            return new Valid();
        };
    }

    /** Password must include the dollar sign ('$'). */
    static UserValidation passwordIncludesDollarSign() {
        return user -> user.getPassword().contains("$")
                ? new Valid()
                : new Invalid("Password must include the dollar sign '$'");
    }

    /** Password must be different from the username. */
    static UserValidation passwordIsDifferentFromUsername() {
        return user -> !user.getPassword().equals(user.getUsername())
                ? new Valid()
                : new Invalid("Password must be different from username");
    }

    /** User age must be greater than 18. */
    static UserValidation ageBiggerThan18() {
        return user -> user.getAge() > 18
                ? new Valid()
                : new Invalid("User must be older than 18");
    }

    /** Username length must be greater than 8 characters. */
    static UserValidation usernameLengthBiggerThan8() {
        return user -> user.getUsername().length() > 8
                ? new Valid()
                : new Invalid("Username must be longer than 8 characters");
    }
}
