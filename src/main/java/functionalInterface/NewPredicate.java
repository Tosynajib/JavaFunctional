package functionalInterface;

import java.util.function.Predicate;

public class NewPredicate {

    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09000009760"));

        System.out.println("********************************");

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000009760"));

        System.out.println("*********************************");

        System.out.println(
                "Is phone number valid and contain number 3 = " +
                isPhoneNumberValidPredicate.and(containNumber3).test("09000009760")
        );

        System.out.println(
                "Is phone number valid and contain number 3 = " +
                        // you can use "or" also and replace the 3 with 0 and answer will still be true
                isPhoneNumberValidPredicate.and(containNumber3).test("07000000003")
        );

    }

    // without predicate
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    // with predicate
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
