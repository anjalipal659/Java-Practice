
import java.util.concurrent.CompletableFuture;

class CFCopyPlacementService {

    public CompletableFuture<String> fetchPlacementData() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Task interrupted", e);
            }

            return "Placement data loaded successfully";
        });
    }
}

public class DesignPatternCompletableFutureCopy {

    public static void main(String[] args) {

        CFCopyPlacementService service =
                new CFCopyPlacementService();

        CompletableFuture<String> original =
                service.fetchPlacementData();

        CompletableFuture<String> copy = original.copy();

        copy.complete("Fake placement data");

        System.out.println("Original: " + original.join());
        System.out.println("Copy: " + copy.join());
    }
}
