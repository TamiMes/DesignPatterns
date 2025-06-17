package il.ac.hit.validation;

import il.ac.hit.validation.UserValidation;
import il.ac.hit.validation.ValidationResult;

public class UserValidationV2Demo {
    public static void main(String args[]) {

        PlatinumUser  PlatinumUser = new  PlatinumUser("admin","admin@#yzw.co.il","abc123",34);

        UserValidation validation1 = UserValidation.emailLengthBiggerThan10();

        UserValidation validation2 = UserValidation.emailEndsWithIL();
        UserValidation validation3 = UserValidation.passwordIncludesLettersNumbersOnly();



        ValidationResult result = (validation1.and(validation2).and(validation3)).apply( PlatinumUser);
        System.out.println(PlatinumUser);

        if(result.isValid()) {
            System.out.println("User  is valid");
        } else {
            System.out.println("User is not valid");
            result.getReason().ifPresent(reason -> System.out.println("Reason: " + reason));
        }


    }

}