import java.util.ArrayList;

public class ArrayListPractice {

    public static void main(String[] args) {

        // 1. Create ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Add elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("ArrayList: " + numbers);

        // 3. Add at specific index
        numbers.add(1, 15);

        System.out.println("After adding: " + numbers);

        // 4. Get element
        System.out.println("Element at index 2: " + numbers.get(2));

        // 5. Update element
        numbers.set(2, 25);

        System.out.println("After update: " + numbers);

        // 6. Remove element
        numbers.remove(3);

        System.out.println("After remove: " + numbers);

        // 7. Check element
        System.out.println("Contains 20: " + numbers.contains(20));

        // 8. Size
        System.out.println("Size: " + numbers.size());

        // 9. Loop through ArrayList
        System.out.println("Elements:");

        for (int number : numbers) {
            System.out.println(number);
        }

        // 10. Clear ArrayList
        numbers.clear();

        System.out.println("After clear: " + numbers);
    }
}