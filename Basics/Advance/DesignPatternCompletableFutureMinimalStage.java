
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

class CFMinimalStagePlacementService {

    public CompletionStage<String> fetchPlacementData() {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException(
                                "Task interrupted", e
                        );
                    }

                    return "Placement data loaded successfully";
                });

        return future.minimalCompletionStage();
    }
}

public class DesignPatternCompletableFutureMinimalStage {

    public static void main(String[] args) {

        CFMinimalStagePlacementService service =
                new CFMinimalStagePlacementService();

        CompletionStage<String> stage =
                service.fetchPlacementData();

        stage.thenAccept(result ->
                System.out.println("Result: " + result)
        ).toCompletableFuture().join();
    }
}
