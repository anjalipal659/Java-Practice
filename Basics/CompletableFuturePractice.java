import java.util.concurrent.CompletableFuture;

public class CompletableFuturePractice {

    public static void main(String[] args) {

        // 1. Run task asynchronously
        CompletableFuture<Void> task =
                CompletableFuture.runAsync(() -> {

                    System.out.println(
                            "Task running on: "
                                    + Thread.currentThread().getName()
                    );

                    System.out.println("Task completed!");
                });

        task.join();


        // 2. Return a value
        CompletableFuture<Integer> number =
                CompletableFuture.supplyAsync(() -> {

                    System.out.println(
                            "\nCalculating..."
                    );

                    return 100;
                });

        System.out.println(
                "Result: " + number.join()
        );


        // 3. thenApply() - transform result
        CompletableFuture<Integer> square =
                CompletableFuture
                        .supplyAsync(() -> 10)
                        .thenApply(n -> n * n);

        System.out.println(
                "Square: " + square.join()
        );


        // 4. thenAccept() - consume result
        CompletableFuture
                .supplyAsync(() -> "Java")
                .thenAccept(value ->
                        System.out.println(
                                "Value: " + value
                        )
                )
                .join();


        // 5. thenCombine() - combine two tasks
        CompletableFuture<Integer> first =
                CompletableFuture.supplyAsync(() -> 100);

        CompletableFuture<Integer> second =
                CompletableFuture.supplyAsync(() -> 200);

        CompletableFuture<Integer> total =
                first.thenCombine(
                        second,
                        (a, b) -> a + b
                );

        System.out.println(
                "\nTotal: " + total.join()
        );


        // 6. Exception handling
        CompletableFuture<Integer> result =
                CompletableFuture
                        .supplyAsync(() -> 10 / 0)
                        .exceptionally(e -> {

                            System.out.println(
                                    "\nException: "
                                            + e.getMessage()
                            );

                            return 0;
                        });

        System.out.println(
                "Final Result: " + result.join()
        );
    }
}