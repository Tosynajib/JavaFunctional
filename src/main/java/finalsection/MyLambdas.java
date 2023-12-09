package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyLambdas {
    public static void main(String[] args) {

        // replacing this with lambda method
        //Function<String, String> upperCaseName = name -> name.toUpperCase();
        //Function<String, String> upperCaseName = String::toUpperCase;
//        Function<String, String> upperCaseName = name -> {
            // logic

            // normal function
//            if (name.isBlank()) throw new IllegalArgumentException("");
//            return name.toUpperCase();
//        };
            //Bi function
            BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
                //Logic
                if (name.isBlank()) throw new IllegalArgumentException("");
                System.out.println(age);
                return name.toUpperCase();
            };
            // declare variable
            // upperCaseName.apply("Tosin", 18);

              System.out.println(upperCaseName.apply("Tosin", 18));


//            System.out.println(upperCaseName.apply("Tosin", 18));


    }
}