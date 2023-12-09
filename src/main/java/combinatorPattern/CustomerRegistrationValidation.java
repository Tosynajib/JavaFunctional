package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorPattern.CustomerRegistrationValidation.*;
import static combinatorPattern.CustomerRegistrationValidation.ValidateResult.*;

public interface CustomerRegistrationValidation
    //  import static report of the ValidationResult
        extends Function<Customer, ValidateResult> {

    static CustomerRegistrationValidation isEmailValid () {
        return customer -> customer.getEmail().contains("@") ?
                // add static import to EMAIL_NOT_VALID
                // ValidateResult.SUCCESS : ValidateResult.EMAIL_NOT_VALID;
                // same for SUCCESS also
                // ValidateResult.SUCCESS : EMAIL_NOT_VALID;
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidation isPhoneNumberValid () {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidation isAdult () {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidation and (CustomerRegistrationValidation other) {
        return customer -> {
            // apply this to variable
            // this.apply(customer);
            ValidateResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

   enum ValidateResult {
       SUCCESS,
       PHONE_NUMBER_NOT_VALID,
       EMAIL_NOT_VALID,
       IS_NOT_AN_ADULT
   }
}
