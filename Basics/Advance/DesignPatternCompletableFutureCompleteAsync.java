
import java.util.concurrent.CompletableFuture;

public class DesignPatternCompletableFutureCompleteAsync {

    public static void main(String[] args) {

        CompletableFuture<String> future = new CompletableFuture<>();

        future.completeAsync(() -> {
            System.out.println("Task running on: "
                    + Thread.currentThread().getName());

            return "Placement data loaded successfully";
        });

        String result = future.join();

        System.out.println("Result: " + result);
        System.out.println("Completed: " + future.isDone());
    }
}
