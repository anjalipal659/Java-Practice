import java.util.ArrayList;
import java.util.Iterator;

public class IteratorPractice {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Anjali");
        names.add("Rahul");
        names.add("Priya");
        names.add("Aman");

        // Create Iterator
        Iterator<String> iterator = names.iterator();

        // Traverse using Iterator
        System.out.println("Names:");

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // Remove elements using Iterator
        Iterator<String> removeIterator = names.iterator();

        while (removeIterator.hasNext()) {

            String name = removeIterator.next();

            if (name.equals("Rahul")) {
                removeIterator.remove();
            }
        }

        System.out.println("\nAfter removing Rahul:");

        for (String name : names) {
            System.out.println(name);
        }
    }
}