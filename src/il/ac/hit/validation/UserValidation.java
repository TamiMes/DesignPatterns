package il.ac.hit.validation;

import java.util.function.Function;

public interface UserValidation extends Function<User, ValidationResult> {

    default UserValidation and(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }

    default UserValidation or(UserValidation other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.isValid() ? result : other.apply(user);
        };
    }
}

