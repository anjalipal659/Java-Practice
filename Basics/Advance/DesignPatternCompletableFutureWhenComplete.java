
import java.util.concurrent.CompletableFuture;

class CFWhenCompletePlacementService {

    public String fetchPlacementData() {
        return "Placement data loaded successfully";
    }
}

public class DesignPatternCompletableFutureWhenComplete {

    public static void main(String[] args) {

        CFWhenCompletePlacementService service =
                new CFWhenCompletePlacementService();

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(
                        service::fetchPlacementData
                );

        CompletableFuture<String> observedFuture =
                future.whenComplete((result, error) -> {

                    if (error != null) {
                        System.out.println(
                                "Log: Task failed - " + error.getMessage()
                        );
                    } else {
                        System.out.println(
                                "Log: Task completed successfully"
                        );
                    }
                });

        System.out.println("Final result: " + observedFuture.join());
    }
}
