
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class CFAllOfPlacementService {

    public String fetchStudyProgress() {
        sleep(1000);
        return "Study progress: 80%";
    }

    public String fetchCodingProgress() {
        sleep(1500);
        return "Coding progress: 65%";
    }

    public String fetchCompanyProgress() {
        sleep(800);
        return "Company applications: 12";
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

public class DesignPatternCompletableFutureAllOf {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        CFAllOfPlacementService service =
                new CFAllOfPlacementService();

        CompletableFuture<String> studyTask =
                CompletableFuture.supplyAsync(service::fetchStudyProgress);

        CompletableFuture<String> codingTask =
                CompletableFuture.supplyAsync(service::fetchCodingProgress);

        CompletableFuture<String> companyTask =
                CompletableFuture.supplyAsync(service::fetchCompanyProgress);

        CompletableFuture<Void> allTasks =
                CompletableFuture.allOf(
                        studyTask, codingTask, companyTask
                );

        System.out.println("Fetching placement dashboard data...");

        allTasks.join();

        System.out.println("\nAll tasks completed!");
        System.out.println(studyTask.get());
        System.out.println(codingTask.get());
        System.out.println(companyTask.get());
    }
}