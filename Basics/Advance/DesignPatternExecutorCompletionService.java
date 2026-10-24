
import java.util.concurrent.*;

public class DesignPatternExecutorCompletionService {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            CompletionService<String> service =
                    new ExecutorCompletionService<>(executor);

            service.submit(() -> {
                Thread.sleep(1500);
                return "Java task completed";
            });

            service.submit(() -> {
                Thread.sleep(300);
                return "SQL task completed";
            });

            service.submit(() -> {
                Thread.sleep(800);
                return "DSA task completed";
            });

            for (int i = 0; i < 3; i++) {
                Future<String> result = service.take();
                System.out.println(result.get());
            }
        } finally {
            executor.shutdown();
        }
    }
}
