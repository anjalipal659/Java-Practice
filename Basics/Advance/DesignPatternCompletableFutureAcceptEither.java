
import java.util.concurrent.CompletableFuture;

class CFAcceptEitherPlacementService {

    public CompletableFuture<String> fetchFromPortalA() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1800);
            return "Portal A: TCS placement details received";
        });
    }

    public CompletableFuture<String> fetchFromPortalB() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return "Portal B: Infosys placement details received";
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

public class DesignPatternCompletableFutureAcceptEither {

    public static void main(String[] args) {

        CFAcceptEitherPlacementService service =
                new CFAcceptEitherPlacementService();

        CompletableFuture<String> portalA =
                service.fetchFromPortalA();

        CompletableFuture<String> portalB =
                service.fetchFromPortalB();

        CompletableFuture<Void> action =
                portalA.acceptEither(
                        portalB,
                        response -> System.out.println(
                                "First response received: " + response
                        )
                );

        action.join();

        System.out.println("Placement response processed.");
    }
}
