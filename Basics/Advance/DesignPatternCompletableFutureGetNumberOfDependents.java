
import java.util.concurrent.CompletableFuture;

public class DesignPatternCompletableFutureGetNumberOfDependents {

    public static void main(String[] args) {

        CompletableFuture<String> future = new CompletableFuture<>();

        CompletableFuture<Integer> stage1 =
                future.thenApply(String::length);

        CompletableFuture<String> stage2 =
                future.thenApply(String::toUpperCase);

        CompletableFuture<String> stage3 =
                future.thenApply(String::trim);

        System.out.println("Dependents before completion: "
                + future.getNumberOfDependents());

        future.complete("Java Placement");

        System.out.println("Original result: " + future.join());
        System.out.println("Length: " + stage1.join());
        System.out.println("Uppercase: " + stage2.join());
        System.out.println("Trimmed: " + stage3.join());

        System.out.println("Dependents after completion: "
                + future.getNumberOfDependents());
    }
}
