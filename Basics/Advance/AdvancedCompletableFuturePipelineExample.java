
import java.util.concurrent.CompletableFuture;

public class AdvancedCompletableFuturePipelineExample {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Fetching student data...");
                    return "Anjali";
                });

        CompletableFuture<String> result = future
                .thenApply(name -> {
                    System.out.println("Processing student data...");
                    return "Welcome, " + name;
                })
                .thenApply(message -> message.toUpperCase());

        result.thenAccept(message ->
                System.out.println("Final Result: " + message)
        ).join();

        System.out.println("Program completed.");
    }
}
