
import java.util.concurrent.ConcurrentSkipListMap;

public class AdvancedConcurrentSkipListMapExample {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> students =
                new ConcurrentSkipListMap<>();

        students.put(103, "Riya");
        students.put(101, "Anjali");
        students.put(102, "Priya");

        System.out.println("Students in sorted ID order:");

        students.forEach((id, name) ->
                System.out.println(id + " : " + name)
        );

        System.out.println("First Entry: " + students.firstEntry());
        System.out.println("Last Entry: " + students.lastEntry());

        students.putIfAbsent(104, "Neha");

        System.out.println("Total Students: " + students.size());
    }
}
