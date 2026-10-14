
import java.util.concurrent.CompletableFuture;

class CFRunAfterEitherPlacementService {

    public CompletableFuture<String> fetchCodingResult() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return "Coding assessment completed";
        });
    }

    public CompletableFuture<String> fetchAptitudeResult() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return "Aptitude assessment completed";
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

public class DesignPatternCompletableFutureRunAfterEither {

    public static void main(String[] args) {

        CFRunAfterEitherPlacementService service =
                new CFRunAfterEitherPlacementService();

        CompletableFuture<String> codingFuture =
                service.fetchCodingResult();

        CompletableFuture<String> aptitudeFuture =
                service.fetchAptitudeResult();

        CompletableFuture<Void> action =
                codingFuture.runAfterEither(
                        aptitudeFuture,
                        () -> System.out.println(
                                "At least one assessment completed successfully."
                        )
                );

        action.join();

        System.out.println("Continuing placement workflow.");
    }
}
