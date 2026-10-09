
import java.util.concurrent.CompletableFuture;

class CFExceptionallyPlacementService {

    public String fetchCompanyData() {
        throw new RuntimeException("Company service is unavailable");
    }
}

public class DesignPatternCompletableFutureExceptionally {

    public static void main(String[] args) {

        CFExceptionallyPlacementService service =
                new CFExceptionallyPlacementService();

        CompletableFuture<String> companyFuture =
                CompletableFuture.supplyAsync(
                        service::fetchCompanyData
                );

        CompletableFuture<String> handledFuture =
                companyFuture.exceptionally(error -> {
                    System.out.println(
                            "Error occurred: " + error.getMessage()
                    );

                    return "Fallback: Company data is temporarily unavailable";
                });

        System.out.println(handledFuture.join());
    }
}