
import java.util.concurrent.atomic.AtomicMarkableReference;

public class AdvancedAtomicMarkableReferenceExample {
    public static void main(String[] args) {
        AtomicMarkableReference<String> task =
                new AtomicMarkableReference<>("Report", false);

        boolean[] markHolder = new boolean[1];

        String name = task.get(markHolder);

        System.out.println("Task: " + name);
        System.out.println("Processed: " + markHolder[0]);

        boolean updated = task.compareAndSet(
                "Report",
                "Report",
                false,
                true
        );

        System.out.println("Mark Updated: " + updated);

        task.get(markHolder);
        System.out.println("Processed: " + markHolder[0]);
    }
}
