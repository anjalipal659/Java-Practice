import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    public static void main(String[] args) {

        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30, 35, 40);

        // 1. Print all numbers
        System.out.println("All numbers:");

        numbers.stream()
                .forEach(number -> System.out.println(number));


        // 2. Filter even numbers
        System.out.println("\nEven numbers:");

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(number -> System.out.println(number));


        // 3. Filter numbers greater than 20
        System.out.println("\nNumbers greater than 20:");

        numbers.stream()
                .filter(number -> number > 20)
                .forEach(number -> System.out.println(number));


        // 4. Square each number
        System.out.println("\nSquares:");

        numbers.stream()
                .map(number -> number * number)
                .forEach(number -> System.out.println(number));


        // 5. Store filtered values in a List
        List<Integer> evenNumbers =
                numbers.stream()
                        .filter(number -> number % 2 == 0)
                        .collect(Collectors.toList());

        System.out.println("\nEven List: " + evenNumbers);


        // 6. Find sum
        int sum =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        System.out.println("\nSum = " + sum);


        // 7. Find maximum
        int max =
                numbers.stream()
                        .max(Integer::compareTo)
                        .orElse(0);

        System.out.println("Maximum = " + max);


        // 8. Find minimum
        int min =
                numbers.stream()
                        .min(Integer::compareTo)
                        .orElse(0);

        System.out.println("Minimum = " + min);


        // 9. Sort numbers
        System.out.println("\nSorted numbers:");

        numbers.stream()
                .sorted()
                .forEach(number -> System.out.println(number));


        // 10. Count even numbers
        long count =
                numbers.stream()
                        .filter(number -> number % 2 == 0)
                        .count();

        System.out.println("\nEven count = " + count);
    }
}