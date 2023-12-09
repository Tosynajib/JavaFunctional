package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class NewSupplier {

    public static void main(String[] args) {
        // normal java function
        System.out.println(gerDBConnectUrl());

        // Using a Supplier
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    // normal java function
    static String gerDBConnectUrl () {
        return "jdbc://localhost:5432/users";
    }

    // using a supplier
    // the String can be replaced with any data type
    static Supplier<List<String>> getDBConnectionUrlSupplier = ()
            -> List.of(
                    "jdbc://localhost:5432/users",
            "jdbc://localhost:5432/customer");
}
