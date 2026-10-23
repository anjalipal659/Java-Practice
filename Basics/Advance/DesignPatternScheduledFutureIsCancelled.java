
import java.util.concurrent.*;

public class DesignPatternScheduledFutureIsCancelled {

    public static void main(String[] args) {

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        try {
            ScheduledFuture<?> task = scheduler.schedule(
                    () -> System.out.println("Task executed"),
                    10,
                    TimeUnit.SECONDS
            );

            System.out.println("Before cancellation: "
                    + task.isCancelled());

            boolean cancelled = task.cancel(false);

            System.out.println("Cancel successful: " + cancelled);
            System.out.println("After cancellation: "
                    + task.isCancelled());
            System.out.println("Is done: " + task.isDone());

        } finally {
            scheduler.shutdown();
        }
    }
}
