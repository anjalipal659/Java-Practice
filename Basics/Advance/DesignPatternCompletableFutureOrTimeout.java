
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletionException;

class CFOrTimeoutPlacementService {

    public String fetchCompanyData() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Task interrupted", e);
        }

        return "Company placement data loaded successfully";
    }
}

public class DesignPatternCompletableFutureOrTimeout {

    public static void main(String[] args) {

        CFOrTimeoutPlacementService service =
                new CFOrTimeoutPlacementService();

        CompletableFuture<String> companyFuture =
                CompletableFuture.supplyAsync(
                        service::fetchCompanyData
                );

        companyFuture.orTimeout(1, TimeUnit.SECONDS);

        try {
            System.out.println(companyFuture.join());
        } catch (CompletionException e) {
            System.out.println(
                    "Request failed: " + e.getCause().getClass().getSimpleName()
            );
            System.out.println(
                    "Company data request timed out."
            );
        }
    }
}
