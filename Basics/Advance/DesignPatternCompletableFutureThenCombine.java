
import java.util.concurrent.CompletableFuture;

class CFThenCombinePlacementService {

    public CompletableFuture<Integer> fetchCodingScore() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching coding score...");
            return 85;
        });
    }

    public CompletableFuture<Integer> fetchAptitudeScore() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching aptitude score...");
            return 75;
        });
    }
}

public class DesignPatternCompletableFutureThenCombine {

    public static void main(String[] args) {

        CFThenCombinePlacementService service =
                new CFThenCombinePlacementService();

        CompletableFuture<Integer> codingFuture =
                service.fetchCodingScore();

        CompletableFuture<Integer> aptitudeFuture =
                service.fetchAptitudeScore();

        CompletableFuture<String> result =
                codingFuture.thenCombine(
                        aptitudeFuture,
                        (coding, aptitude) -> {
                            int total = coding + aptitude;
                            return "Coding Score: " + coding
                                    + "\nAptitude Score: " + aptitude
                                    + "\nTotal Score: " + total;
                        }
                );

        System.out.println(result.join());
    }
}
