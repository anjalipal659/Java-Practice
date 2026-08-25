import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicePractice {

    public static void main(String[] args) {

        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Task 1
        executor.submit(() -> {
            System.out.println("Task 1 is running by "
                    + Thread.currentThread().getName());
        });

        // Task 2
        executor.submit(() -> {
            System.out.println("Task 2 is running by "
                    + Thread.currentThread().getName());
        });

        // Task 3
        executor.submit(() -> {
            System.out.println("Task 3 is running by "
                    + Thread.currentThread().getName());
        });

        // Task 4
        executor.submit(() -> {
            System.out.println("Task 4 is running by "
                    + Thread.currentThread().getName());
        });

        // Task 5
        executor.submit(() -> {
            System.out.println("Task 5 is running by "
                    + Thread.currentThread().getName());
        });

        // Shutdown executor
        executor.shutdown();

        System.out.println("All tasks submitted.");
    }
}