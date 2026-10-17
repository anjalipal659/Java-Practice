
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DesignPatternCompletableFutureCompleteExceptionally {

    public static void main(String[] args) {

        CompletableFuture<String> future = new CompletableFuture<>();

        boolean completed = future.completeExceptionally(
                new RuntimeException("Placement service unavailable")
        );

        System.out.println("Completed exceptionally: " + completed);
        System.out.println("Future done: " + future.isDone());

        try {
            String result = future.join();
            System.out.println("Result: " + result);
        } catch (CompletionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
    }
}
