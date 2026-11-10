
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamCollectorsExample {

    public static void main(String[] args) {

        List<String> students = Arrays.asList(
                "Anjali", "Rahul", "Aman",
                "Anshita", "Priya", "Arjun"
        );

        Map<Integer, List<String>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(
                                String::length
                        ));

        System.out.println("Grouped by name length:");
        System.out.println(grouped);

        Map<Boolean, List<String>> partitioned =
                students.stream()
                        .collect(Collectors.partitioningBy(
                                name -> name.length() > 5
                        ));

        System.out.println("\nPartitioned students:");
        System.out.println(partitioned);

        long total = students.stream()
                .collect(Collectors.counting());

        System.out.println("\nTotal students: " + total);
    }
}
