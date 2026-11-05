
import java.util.concurrent.ConcurrentLinkedQueue;

public class AdvancedConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> tasks =
                new ConcurrentLinkedQueue<>();

        tasks.offer("Study Java");
        tasks.offer("Practice DSA");
        tasks.offer("Learn SQL");

        System.out.println("All Tasks: " + tasks);

        System.out.println("Next Task: " + tasks.peek());

        System.out.println("Completed Task: " + tasks.poll());

        System.out.println("Remaining Tasks: " + tasks);
    }
}
