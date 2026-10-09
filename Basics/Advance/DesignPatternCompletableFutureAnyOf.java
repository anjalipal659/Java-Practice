
import java.util.concurrent.CompletableFuture;

class CFAnyOfPlacementService {

    public String fetchFromServiceA() {
        sleep(2000);
        return "Service A: Placement data received";
    }

    public String fetchFromServiceB() {
        sleep(1000);
        return "Service B: Placement data received";
    }

    public String fetchFromServiceC() {
        sleep(1500);
        return "Service C: Placement data received";
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

public class DesignPatternCompletableFutureAnyOf {

    public static void main(String[] args) {

        CFAnyOfPlacementService service =
                new CFAnyOfPlacementService();

        CompletableFuture<String> serviceA =
                CompletableFuture.supplyAsync(
                        service::fetchFromServiceA);

        CompletableFuture<String> serviceB =
                CompletableFuture.supplyAsync(
                        service::fetchFromServiceB);

        CompletableFuture<String> serviceC =
                CompletableFuture.supplyAsync(
                        service::fetchFromServiceC);

        CompletableFuture<Object> firstResult =
                CompletableFuture.anyOf(
                        serviceA, serviceB, serviceC);

        System.out.println("Waiting for the first response...");

        firstResult.thenAccept(result ->
                System.out.println("First response: " + result)
        ).join();
    }
}