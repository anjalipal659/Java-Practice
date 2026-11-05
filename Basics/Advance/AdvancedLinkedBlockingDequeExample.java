
import java.util.concurrent.LinkedBlockingDeque;

public class AdvancedLinkedBlockingDequeExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> tasks =
                new LinkedBlockingDeque<>(3);

        tasks.putFirst("Java");
        tasks.putLast("SQL");
        tasks.putLast("DSA");

        System.out.println("Tasks: " + tasks);

        System.out.println("First Task: " + tasks.takeFirst());
        System.out.println("Last Task: " + tasks.takeLast());

        System.out.println("Remaining Tasks: " + tasks);
    }
}
