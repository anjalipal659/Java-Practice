
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CancellationException;

public class DesignPatternCompletableFutureCancellation {

    public static void main(String[] args) {

        CompletableFuture<String> future = new CompletableFuture<>();

        System.out.println("Before cancellation:");
        System.out.println("Done: " + future.isDone());
        System.out.println("Cancelled: " + future.isCancelled());

        boolean cancelled = future.cancel(false);

        System.out.println("\nAfter cancellation:");
        System.out.println("Cancel successful: " + cancelled);
        System.out.println("Done: " + future.isDone());
        System.out.println("Cancelled: " + future.isCancelled());

        try {
            System.out.println(future.join());
        } catch (CancellationException e) {
            System.out.println("Task was cancelled.");
        }
    }
}
