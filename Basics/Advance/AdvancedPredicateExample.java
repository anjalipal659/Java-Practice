
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AdvancedPredicateExample {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30, 35);

        Predicate<Integer> isEven =
                number -> number % 2 == 0;

        System.out.println("Even numbers:");

        numbers.stream()
                .filter(isEven)
                .forEach(System.out::println);

        Predicate<Integer> greaterThan20 =
                number -> number > 20;

        System.out.println("Numbers greater than 20:");

        numbers.stream()
                .filter(greaterThan20)
                .forEach(System.out::println);

        System.out.println("Is 25 even? " + isEven.test(25));
    }
}
