package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Supplier<IllegalStateException> exception = ()
//                -> new IllegalStateException("exception");
//
//        Object value= Optional.ofNullable("Hello")
//                        .orElseThrow(exception);
//
//        System.out.println(value);

//             using ifPresent
        Optional.ofNullable("tosynajib@gmail.com")
                .ifPresent(email -> System.out.println("sending email to " + email));

        System.out.println("****************************************");

//             using ifPresentOrElse
        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        });


        System.out.println("******************************************");
        System.out.println("example on how to use a Optional Class");
        System.out.println("******************************************");
//     Java program without Optional Class
//        String[] words = new String[10];
//        String word = words[5].toLowerCase();
//        System.out.print(word);
//   Output: Exception in thread "main" java.lang.NullPointerException

//      Java program with Optional Class
        String[] words = new String[10];
        Optional<String> checkNull
                = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else
            System.out.println("word is null");


    }
}
