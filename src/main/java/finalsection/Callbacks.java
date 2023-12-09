package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        System.out.println("****************hello****************");

        hello("Tosin", null, value -> {
            System.out.println("no lastName provided for " + value);
        });

//        hello2("Tosin", null, () -> {
//            System.out.println("no lastName provided for ");
//        });
        // you can convert it to a lambda expression
        System.out.println("****************hello2****************");
        hello2("Tosin",
                null,
                () -> System.out.println("no lastName provided for"));

    }



    // this method comes first before the above
    static void hello(String  firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }

    static void hello2(String  firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        }else {
            callback.run();
        }
    }


//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName)
//        }else {
//            callback();
//        }
//    }

}
