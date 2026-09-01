import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadingAdvanced {

    public static void main(String[] args) {

        // Create thread pool
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        try {

            // 1. Callable task
            Callable<Integer> task1 = () -> {

                System.out.println(
                        "Task 1 running on: "
                                + Thread.currentThread().getName()
                );

                Thread.sleep(1000);

                return 100;
            };


            // 2. Submit task
            Future<Integer> future1 =
                    executor.submit(task1);


            // 3. Another Callable task
            Callable<Integer> task2 = () -> {

                System.out.println(
                        "Task 2 running on: "
                                + Thread.currentThread().getName()
                );

                Thread.sleep(1000);

                return 200;
            };

            Future<Integer> future2 =
                    executor.submit(task2);


            // 4. Get results
            int result1 = future1.get();
            int result2 = future2.get();

            System.out.println("\nTask 1 Result: "
                    + result1);

            System.out.println("Task 2 Result: "
                    + result2);

            System.out.println("Total: "
                    + (result1 + result2));


            // 5. Check task status
            System.out.println(
                    "\nTask 1 Done: "
                            + future1.isDone()
            );

            System.out.println(
                    "Task 2 Done: "
                            + future2.isDone()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );

        } finally {

            // Shutdown thread pool
            executor.shutdown();

            System.out.println(
                    "Executor shutdown."
            );
        }
    }
}