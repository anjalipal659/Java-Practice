
import java.util.Arrays;
import java.util.List;

public class AdvancedMethodReferenceExample {

    public static void main(String[] args) {

        List<String> students = Arrays.asList(
                "Anjali",
                "Rahul",
                "Priya",
                "Aman"
        );

        System.out.println("Student Names:");

        students.forEach(System.out::println);

        System.out.println("\nUppercase Names:");

        students.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("\nSorted Names:");

        students.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
