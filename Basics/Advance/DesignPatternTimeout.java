import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TimeoutPlacementService {

    public String fetchCompanyData() throws Exception {

        System.out.println("Fetching company data...");

        // Simulate a slow operation
        Thread.sleep(5000);

        return "Company data received successfully.";
    }
}


class PlacementTimeoutHandler {

    private long timeoutSeconds;

    public PlacementTimeoutHandler(long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public String execute(TimeoutPlacementService service) {

        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<String> future =
                executor.submit(() -> service.fetchCompanyData());

        try {

            return future.get(
                    timeoutSeconds,
                    TimeUnit.SECONDS
            );

        } catch (TimeoutException e) {

            future.cancel(true);

            return "Timeout: Company service took too long.";

        } catch (Exception e) {

            return "Service failed: " + e.getMessage();

        } finally {

            executor.shutdownNow();
        }
    }
}


public class DesignPatternTimeout {

    public static void main(String[] args) {

        TimeoutPlacementService service =
                new TimeoutPlacementService();

        PlacementTimeoutHandler timeoutHandler =
                new PlacementTimeoutHandler(2);

        String result =
                timeoutHandler.execute(service);

        System.out.println();
        System.out.println("Result:");
        System.out.println(result);
    }
}