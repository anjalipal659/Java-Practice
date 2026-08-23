import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaPractice {

    public static void main(String[] args) {

        // 1. Lambda with Runnable
        Runnable task = () -> {
            System.out.println("Java Lambda is running");
        };

        task.run();


        // 2. Lambda with ArrayList
        ArrayList<String> names = new ArrayList<>();

        names.add("Anjali");
        names.add("Rahul");
        names.add("Priya");
        names.add("Aman");

        System.out.println("\nNames:");

        names.forEach(name -> System.out.println(name));


        // 3. Lambda with condition
        System.out.println("\nNames starting with A:");

        names.forEach(name -> {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        });


        // 4. Lambda with numbers
        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);

        System.out.println("\nEven numbers:");

        numbers.forEach(number -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        });


        // 5. Lambda with sorting
        numbers.sort((a, b) -> a - b);

        System.out.println("\nSorted numbers:");

        numbers.forEach(number -> System.out.println(number));
    }
}