
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;

public class DesignPatternScheduledExecutorService {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        try {
            // Run once after a delay of 2 seconds
            scheduler.schedule(() -> {
                System.out.println("Reminder: Revise Java DSA!");
            }, 2, TimeUnit.SECONDS);

            // Run repeatedly, starting after 1 second
            ScheduledFuture<?> repeatedTask =
                    scheduler.scheduleAtFixedRate(() -> {
                        System.out.println("Practicing Java...");
                    }, 1, 2, TimeUnit.SECONDS);

            // Stop the repeated task after 5 seconds
            scheduler.schedule(() -> {
                repeatedTask.cancel(false);
                System.out.println("Repeated task stopped.");
                scheduler.shutdown();
            }, 5, TimeUnit.SECONDS);

        } catch (RuntimeException e) {
            scheduler.shutdown();
            throw e;
        }
    }
}
