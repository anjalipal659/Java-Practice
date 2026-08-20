import java.util.HashSet;

public class HashSetPractice {

    public static void main(String[] args) {

        // 1. Create HashSet
        HashSet<Integer> numbers = new HashSet<>();

        // 2. Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("HashSet: " + numbers);

        // 3. Duplicate value
        numbers.add(20);

        System.out.println("After adding duplicate: " + numbers);

        // 4. Check element
        System.out.println("Contains 30: " + numbers.contains(30));

        // 5. Remove element
        numbers.remove(10);

        System.out.println("After removing 10: " + numbers);

        // 6. Size
        System.out.println("Size: " + numbers.size());

        // 7. Loop
        System.out.println("Elements:");

        for (int number : numbers) {
            System.out.println(number);
        }

        // 8. Clear
        numbers.clear();

        System.out.println("After clear: " + numbers);
    }
}
