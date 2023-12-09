package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidation.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "tosynajib@gmail.com",
                "+08152000058",
                LocalDate.of(2000,1, 1)
        );

       // System.out.println(new CustomerValidatorService().isValid(customer));

        //    if valid we can store customer in db

        // Using combinator pattern
        // add static import
//        CustomerRegistrationValidation
//                .isEmailValid()
//                .and(CustomerRegistrationValidation.isPhoneNumberValid())
//                .and(CustomerRegistrationValidation.isAdult())
        // apply to a variable
//        isEmailValid()
//                .and(isPhoneNumberValid())
//                .and(isAdult())
//                .apply(customer);
         ValidateResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);

        // this will print out the same information as system.out.println(result)

        if (result != ValidateResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
