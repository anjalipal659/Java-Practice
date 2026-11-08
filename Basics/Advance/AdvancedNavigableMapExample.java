
import java.util.NavigableMap;
import java.util.TreeMap;

public class AdvancedNavigableMapExample {

    public static void main(String[] args) {

        NavigableMap<Integer, String> students = new TreeMap<>();

        students.put(101, "Anjali");
        students.put(105, "Rahul");
        students.put(110, "Priya");
        students.put(115, "Aman");
        students.put(120, "Neha");

        System.out.println("All Students: " + students);

        System.out.println("Lowest Key: " + students.firstKey());
        System.out.println("Highest Key: " + students.lastKey());

        System.out.println("Lower than 110: "
                + students.lowerKey(110));

        System.out.println("Higher than 110: "
                + students.higherKey(110));

        System.out.println("Floor of 112: "
                + students.floorKey(112));

        System.out.println("Ceiling of 112: "
                + students.ceilingKey(112));

        System.out.println("Descending Map: "
                + students.descendingMap());
    }
}
