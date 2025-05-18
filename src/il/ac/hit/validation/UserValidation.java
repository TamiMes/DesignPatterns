package il.ac.hit.validation;

import java.util.Optional;
import java.util.function.Function;

/**
 * A combinator-based interface for validating User objects.
 * Supports combining multiple validation rules using logical operations.
 */
@FunctionalInterface
public interface UserValidation extends Function<User, ValidationResult> {

    // AND: both validations must pass
    default UserValidation and(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    // OR: at least one validation must pass
    default UserValidation or(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? result : other.apply(user);
        };
    }

    // XOR: exactly one must pass
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

    // Static method: ALL validations must pass
    static UserValidation all(UserValidation... validations) {
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

    // Static method: NONE of the validations must pass
    static UserValidation none(UserValidation... validations) {
        return user -> {
            for (UserValidation validation : validations) {
                if (validation.apply(user).isValid()) {
                    return new Invalid("At least one validation passed when none should");
                }
            }
            return new Valid();
        };
    }

    static UserValidation emailEndsWithIl() {
        return user -> {
            if (user.getEmail().endsWith("il")) {
                return new Valid();
            } else {
                return new Invalid("Email must end with 'il'");
            }
        };
    }

    static UserValidation emailLengthBiggerThan10() {
        return user -> {
            if (user.getEmail().length() > 10) {
                return new Valid();
            } else {
                return new Invalid("Email must be longer than 10 characters");
            }
        };
    }

    static UserValidation passwordLengthBiggerThan8() {
        return user -> {
            if (user.getPassword().length() > 8) {
                return new Valid();
            } else {
                return new Invalid("Password must be longer than 8 characters");
            }
        };
    }

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

    static UserValidation passwordIncludesDollarSign() {
        return user -> {
            if (user.getPassword().contains("$")) {
                return new Valid();
            } else {
                return new Invalid("Password must include the dollar sign '$'");
            }
        };
    }

    static UserValidation passwordIsDifferentFromUsername() {
        return user -> {
            if (!user.getPassword().equals(user.getUsername())) {
                return new Valid();
            } else {
                return new Invalid("Password must be different from username");
            }
        };
    }

    static UserValidation ageBiggerThan18() {
        return user -> {
            if (user.getAge() > 18) {
                return new Valid();
            } else {
                return new Invalid("User must be older than 18");
            }
        };
    }

    static UserValidation usernameLengthBiggerThan8() {
        return user -> {
            if (user.getUsername().length() > 8) {
                return new Valid();
            } else {
                return new Invalid("Username must be longer than 8 characters");
            }
        };
    }


}
