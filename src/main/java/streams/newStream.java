package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams.newStream.Gender.*;

public class newStream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)

        );

//        people.stream()
//                // you can get the names and gender just by changing the person
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
//                .allMatch(personPredicate);
//                   to say opposite
//                  .anyMatch(personPredicate);
//                 to check if another gender exist or not
                    .noneMatch(personPredicate);

        System.out.println(containsOnlyFemales);

    }
    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
