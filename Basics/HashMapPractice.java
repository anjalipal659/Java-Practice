import java.util.HashMap;

public class HashMapPractice {

    public static void main(String[] args) {

        // 1. Create HashMap
        HashMap<Integer, String> students = new HashMap<>();

        // 2. Add key-value pairs
        students.put(101, "Anjali");
        students.put(102, "Rahul");
        students.put(103, "Priya");
        students.put(104, "Aman");

        System.out.println("Students: " + students);

        // 3. Get value using key
        System.out.println("Student 101: " + students.get(101));

        // 4. Update value
        students.put(101, "Anjali Pal");

        System.out.println("After update: " + students);

        // 5. Check key
        System.out.println("Contains key 102: "
                + students.containsKey(102));

        // 6. Check value
        System.out.println("Contains Priya: "
                + students.containsValue("Priya"));

        // 7. Remove
        students.remove(104);

        System.out.println("After remove: " + students);

        // 8. Size
        System.out.println("Size: " + students.size());

        // 9. Print keys
        System.out.println("\nKeys:");

        for (Integer key : students.keySet()) {
            System.out.println(key);
        }

        // 10. Print values
        System.out.println("\nValues:");

        for (String value : students.values()) {
            System.out.println(value);
        }

        // 11. Print key + value
        System.out.println("\nStudents:");

        for (Integer key : students.keySet()) {
            System.out.println(key + " -> " + students.get(key));
        }
    }
}