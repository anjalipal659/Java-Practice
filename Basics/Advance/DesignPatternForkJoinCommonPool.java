
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.CompletableFuture;

public class DesignPatternForkJoinCommonPool {

    public static void main(String[] args) {

        ForkJoinPool pool = ForkJoinPool.commonPool();

        System.out.println("Common pool: " + pool);
        System.out.println("Parallelism: "
                + pool.getParallelism());

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    return "Java task executed by "
                            + Thread.currentThread().getName();
                });

        System.out.println(future.join());
    }
}
