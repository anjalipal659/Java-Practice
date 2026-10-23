
import java.util.concurrent.*;

public class DesignPatternScheduledFutureIsDone {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        try {
            ScheduledFuture<String> task = scheduler.schedule(
                    () -> "Company data loaded",
                    2,
                    TimeUnit.SECONDS
            );

            System.out.println("Before execution: " + task.isDone());

            System.out.println("Result: " + task.get());

            System.out.println("After execution: " + task.isDone());
        } finally {
            scheduler.shutdown();
        }
    }
}
