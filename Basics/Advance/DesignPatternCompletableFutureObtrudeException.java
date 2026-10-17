
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DesignPatternCompletableFutureObtrudeException {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.completedFuture("Placement Selected");

        System.out.println("Before: " + future.join());

        future.obtrudeException(
                new RuntimeException("Placement status overridden")
        );

        try {
            System.out.println("After: " + future.join());
        } catch (CompletionException e) {
            System.out.println("Exception: " + e.getCause().getMessage());
        }

        System.out.println("Is Completed: " + future.isDone());
    }
}
