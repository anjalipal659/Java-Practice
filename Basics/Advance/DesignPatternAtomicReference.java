
import java.util.concurrent.atomic.AtomicReference;

class PlacementApplicationStatus {

    private final AtomicReference<String> status =
            new AtomicReference<>("Applied");

    public String getStatus() {
        return status.get();
    }

    public boolean updateStatus(
            String expected,
            String newStatus) {

        return status.compareAndSet(
                expected,
                newStatus);
    }
}

public class DesignPatternAtomicReference {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementApplicationStatus application =
                new PlacementApplicationStatus();

        Runnable interviewUpdate = () -> {

            boolean updated =
                    application.updateStatus(
                            "Applied",
                            "Interview Scheduled");

            System.out.println(
                    Thread.currentThread().getName()
                    + " update successful: "
                    + updated);
        };

        Thread t1 = new Thread(
                interviewUpdate, "Recruiter-1");

        Thread t2 = new Thread(
                interviewUpdate, "Recruiter-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(
                "\nFinal Status: "
                + application.getStatus());
    }
}