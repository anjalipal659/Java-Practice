
import java.util.concurrent.CompletableFuture;

class CFApplyToEitherPlacementService {

    public CompletableFuture<String> fetchFromServiceA() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Service A: Placement data received";
        });
    }

    public CompletableFuture<String> fetchFromServiceB() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(800);
            return "Service B: Placement data received";
        });
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Task interrupted", e);
        }
    }
}

public class DesignPatternCompletableFutureApplyToEither {

    public static void main(String[] args) {

        CFApplyToEitherPlacementService service =
                new CFApplyToEitherPlacementService();

        CompletableFuture<String> serviceA =
                service.fetchFromServiceA();

        CompletableFuture<String> serviceB =
                service.fetchFromServiceB();

        CompletableFuture<String> result =
                serviceA.applyToEither(
                        serviceB,
                        response -> "Fastest response: " + response
                );

        System.out.println(result.join());
    }
}
