
import java.util.concurrent.CompletableFuture;

public class DesignPatternCompletableFutureObtrudeValue {
    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.completedFuture("Original Result");

        System.out.println("Before: " + future.join());

        future.obtrudeValue("Forced Result");

        System.out.println("After: " + future.join());

        System.out.println("Is Completed: " + future.isDone());
    }
}
