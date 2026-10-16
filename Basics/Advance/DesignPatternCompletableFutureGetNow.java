
import java.util.concurrent.CompletableFuture;

class CFGetNowPlacementService {

    public CompletableFuture<String> fetchPlacementData() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Task interrupted", e);
            }

            return "Placement data loaded successfully";
        });
    }
}

public class DesignPatternCompletableFutureGetNow {

    public static void main(String[] args) {

        CFGetNowPlacementService service =
                new CFGetNowPlacementService();

        CompletableFuture<String> future =
                service.fetchPlacementData();

        String immediateResult =
                future.getNow("Data is still loading...");

        System.out.println("Immediate result: " + immediateResult);

        String finalResult = future.join();

        System.out.println("Final result: " + finalResult);
    }
}
