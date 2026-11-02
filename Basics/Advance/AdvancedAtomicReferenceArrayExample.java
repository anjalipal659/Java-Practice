
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AdvancedAtomicReferenceArrayExample {
    public static void main(String[] args) {
        AtomicReferenceArray<String> tasks =
                new AtomicReferenceArray<>(3);

        tasks.set(0, "Study Java");
        tasks.set(1, "Practice SQL");
        tasks.set(2, "Update GitHub");

        System.out.println("Initial task: " + tasks.get(0));

        boolean updated = tasks.compareAndSet(
                0, "Study Java", "Practice DSA"
        );

        System.out.println("Update successful: " + updated);

        for (int i = 0; i < tasks.length(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }
}
