
import java.util.concurrent.atomic.AtomicReference;

public class AdvancedAtomicReferenceExample {
    public static void main(String[] args) {

        AtomicReference<String> status =
                new AtomicReference<>("Pending");

        System.out.println("Initial Status: " + status.get());

        boolean updated = status.compareAndSet(
                "Pending",
                "Approved"
        );

        System.out.println("Update Successful: " + updated);
        System.out.println("Current Status: " + status.get());

        status.set("Completed");

        System.out.println("Final Status: " + status.get());
    }
}
