
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;

public class DesignPatternScheduleWithFixedDelay {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        final int[] count = {0};

        ScheduledFuture<?> task = scheduler.scheduleWithFixedDelay(
                () -> {
                    int taskNumber = ++count[0];

                    System.out.println(
                            "Task " + taskNumber + " started"
                    );

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    System.out.println(
                            "Task " + taskNumber + " finished"
                    );
                },
                0,
                2,
                TimeUnit.SECONDS
        );

        scheduler.schedule(() -> {
            task.cancel(false);
            scheduler.shutdown();
            System.out.println("Scheduler stopped.");
        }, 8, TimeUnit.SECONDS);
    }
}
