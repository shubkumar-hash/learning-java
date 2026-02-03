import java.util.*;
import java.util.function.*;

public class FunctionalInterface {

    public static void main(String[] args) {

        // Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(7));

        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println(startsWithA.test("Amit"));
        System.out.println(startsWithA.test("Rahul"));

        // Consumer
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello");
        print.accept("Lambda");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.forEach(n -> System.out.println(n));

        // Supplier
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());
        System.out.println(randomValue.get());

        Supplier<String> message = () -> "Welcome";
        System.out.println(message.get());

        // Function
        Function<String, Integer> lengthFinder = s -> s.length();
        System.out.println(lengthFinder.apply("Java"));
        System.out.println(lengthFinder.apply("Streams"));

        Function<Integer, Integer> square = n -> n * n;
        System.out.println(square.apply(5));

        // Predicate with collection
        List<String> names = Arrays.asList("Amit", "Rahul", "Ankit", "Neha");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        // Consumer with object
        Consumer<Integer> doublePrint = n -> System.out.println(n * 2);
        nums.forEach(doublePrint);

        // Function chaining
        Function<Integer, Integer> add10 = n -> n + 10;
        Function<Integer, Integer> multiply2 = n -> n * 2;

        System.out.println(add10.andThen(multiply2).apply(5));
        System.out.println(add10.compose(multiply2).apply(5));

        // Predicate chaining
        Predicate<Integer> greaterThan10 = n -> n > 10;
        Predicate<Integer> lessThan50 = n -> n < 50;

        nums.stream()
                .filter(greaterThan10.and(lessThan50))
                .forEach(System.out::println);

        // Supplier in loop
        for (int i = 0; i < 3; i++) {
            System.out.println("OTP: " + (int)(Math.random() * 1000));
        }

        // Real usage style
        List<Integer> marks = Arrays.asList(45, 67, 82, 39, 90);

        marks.stream()
                .filter(m -> m > 60)
                .map(m -> m + 5)
                .forEach(m -> System.out.println(m));

        // Method reference
        Consumer<String> printer = System.out::println;
        printer.accept("Method Reference");

        // Custom functional interface
        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;

        System.out.println(add.calculate(10, 5));
        System.out.println(sub.calculate(10, 5));
    }
}

interface Calculator {
    int calculate(int a, int b);
}
