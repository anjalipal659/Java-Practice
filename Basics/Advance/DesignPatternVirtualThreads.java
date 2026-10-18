
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DesignPatternVirtualThreads {

    public static void main(String[] args) throws Exception {

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            Future<String> task1 = executor.submit(() -> {
                Thread.sleep(500);
                return "Study task completed";
            });

            Future<String> task2 = executor.submit(() -> {
                Thread.sleep(300);
                return "Coding task completed";
            });

            System.out.println(task1.get());
            System.out.println(task2.get());

            System.out.println("Both tasks finished.");
        }
    }
}

