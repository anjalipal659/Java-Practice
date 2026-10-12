
import java.util.concurrent.CompletableFuture;

class CFHandlePlacementService {

    public String fetchCompanyData(boolean shouldFail) {
        if (shouldFail) {
            throw new RuntimeException("Company API failed");
        }

        return "TCS placement data loaded successfully";
    }
}

public class DesignPatternCompletableFutureHandle {

    public static void main(String[] args) {

        CFHandlePlacementService service =
                new CFHandlePlacementService();

        CompletableFuture<String> companyFuture =
                CompletableFuture.supplyAsync(
                        () -> service.fetchCompanyData(false)
                );

        CompletableFuture<String> resultFuture =
                companyFuture.handle((result, error) -> {

                    if (error != null) {
                        return "Fallback result: " + error.getMessage();
                    }

                    return "Success: " + result;
                });

        System.out.println(resultFuture.join());
    }
}
