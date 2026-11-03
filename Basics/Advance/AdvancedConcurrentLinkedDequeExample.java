
import java.util.concurrent.ConcurrentLinkedDeque;

public class AdvancedConcurrentLinkedDequeExample {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> tasks =
                new ConcurrentLinkedDeque<>();

        tasks.addFirst("Study Java");
        tasks.addLast("Practice SQL");
        tasks.addFirst("Solve DSA");

        System.out.println("All Tasks: " + tasks);

        System.out.println("First Task: " + tasks.peekFirst());
        System.out.println("Last Task: " + tasks.peekLast());

        System.out.println("Removed First: " + tasks.pollFirst());
        System.out.println("Removed Last: " + tasks.pollLast());

        System.out.println("Remaining Tasks: " + tasks);
    }
}
