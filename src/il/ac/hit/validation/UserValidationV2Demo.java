package il.ac.hit.validation;

import il.ac.hit.validation.UserValidation;
import il.ac.hit.validation.ValidationResult;

public class UserValidationV2Demo {
    public static void main(String args[]) {

        User user = new User("admin","admin@#yzw.co.il","abc123",34);

        UserValidation validation1 = UserValidation.emailLengthBiggerThan10();

        UserValidation validation2 = UserValidation.emailEndsWithIL();

        ValidationResult result = (validation1.and(validation2)).apply(user);

        if(result.isValid()) {

            System.out.println("User is valid");

        } else {

            System.out.println("User is not valid");

        }


    }

}