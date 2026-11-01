
import java.util.concurrent.atomic.AtomicStampedReference;

public class AdvancedAtomicStampedReferenceExample {
    public static void main(String[] args) {

        AtomicStampedReference<String> status =
                new AtomicStampedReference<>("Pending", 1);

        int[] stampHolder = new int[1];

        String current = status.get(stampHolder);

        System.out.println("Current Status: " + current);
        System.out.println("Current Stamp: " + stampHolder[0]);

        boolean updated = status.compareAndSet(
                "Pending",
                "Approved",
                1,
                2
        );

        System.out.println("Update Successful: " + updated);

        current = status.get(stampHolder);

        System.out.println("Updated Status: " + current);
        System.out.println("Updated Stamp: " + stampHolder[0]);
    }
}
