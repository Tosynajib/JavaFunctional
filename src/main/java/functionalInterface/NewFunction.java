package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

//    function interface
public class NewFunction {

    public static void main(String[] args) {
//     function takes 1 argument and produces 1 result
//        you can keep changing the number, it increases by 1
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increasment2 = incrementByOneFunction.apply(1);
        System.out.println(increasment2);

        int multiply = multiplyBy10Function.apply(increasment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        //      BiFunction takes 2 argument and produces 1 result

        //       normal Java function
        System.out.println(
                incrementByOneAndMultiply(4, 100)
        );
        //  BiFunction
        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4, 100)
        );

    }

//      declaring function

    static Function<Integer, Integer> incrementByOneFunction =
        number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
