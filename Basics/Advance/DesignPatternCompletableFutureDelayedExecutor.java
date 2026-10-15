
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

class CFDelayedExecutorPlacementService {

    public String fetchPlacementUpdate() {
        return "New placement update received!";
    }
}

public class DesignPatternCompletableFutureDelayedExecutor {

    public static void main(String[] args) {

        CFDelayedExecutorPlacementService service =
                new CFDelayedExecutorPlacementService();

        Executor delayedExecutor =
                CompletableFuture.delayedExecutor(
                        2, TimeUnit.SECONDS
                );

        System.out.println("Preparing placement update...");

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(
                        service::fetchPlacementUpdate,
                        delayedExecutor
                );

        System.out.println("Main thread can do other work.");

        System.out.println("Result: " + future.join());
    }
}
