
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

class PlacementApplication {
    volatile String status = "Applied";
}

public class AdvancedAtomicReferenceFieldUpdaterExample {

    private static final AtomicReferenceFieldUpdater<
            PlacementApplication, String> updater =
            AtomicReferenceFieldUpdater.newUpdater(
                    PlacementApplication.class,
                    String.class,
                    "status"
            );

    public static void main(String[] args) {
        PlacementApplication application = new PlacementApplication();

        System.out.println("Initial Status: " + application.status);

        boolean updated = updater.compareAndSet(
                application, "Applied", "Shortlisted"
        );

        System.out.println("Update Successful: " + updated);
        System.out.println("Current Status: " + application.status);
    }
}
