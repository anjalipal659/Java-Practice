
import java.util.concurrent.CompletableFuture;

class PlacementFuture<T> extends CompletableFuture<T> {

    @Override
    public <U> CompletableFuture<U> newIncompleteFuture() {
        return new PlacementFuture<U>();
    }
}

public class DesignPatternCompletableFutureNewIncompleteFuture {

    public static void main(String[] args) {

        PlacementFuture<String> future = new PlacementFuture<>();

        CompletableFuture<Integer> result =
                future.thenApply(String::length);

        System.out.println("Original future type: "
                + future.getClass().getSimpleName());

        System.out.println("Dependent future type: "
                + result.getClass().getSimpleName());

        future.complete("Java Placement");

        System.out.println("Result length: " + result.join());
    }
}
