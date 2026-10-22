
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DesignPatternThreadFactory {

    public static void main(String[] args) {

        ThreadFactory factory = new ThreadFactory() {
            private int count = 1;

            @Override
            public Thread newThread(Runnable task) {
                return Thread.ofPlatform()
                        .name("Placement-Worker-" + count++)
                        .unstarted(task);
            }
        };

        try (ExecutorService executor =
                     Executors.newFixedThreadPool(3, factory)) {

            for (int i = 1; i <= 5; i++) {
                int taskId = i;

                executor.submit(() -> {
                    System.out.println(
                            "Task " + taskId + " executed by "
                                    + Thread.currentThread().getName()
                    );
                });
            }
        }

        System.out.println("All placement tasks submitted.");
    }
}
