
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class CFCompleteOnTimeoutPlacementService {

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

public class DesignPatternCompletableFutureCompleteOnTimeout {

    public static void main(String[] args) {

        CFCompleteOnTimeoutPlacementService service =
                new CFCompleteOnTimeoutPlacementService();

        CompletableFuture<String> companyFuture =
                CompletableFuture.supplyAsync(
                        service::fetchCompanyData
                );

        companyFuture.completeOnTimeout(
                "Fallback: Company data is temporarily unavailable",
                1,
                TimeUnit.SECONDS
        );

        System.out.println(companyFuture.join());
    }
}
