
import java.util.concurrent.CountDownLatch;

public class AdvancedCountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            final int workerId = i;

            Thread worker = new Thread(() -> {
                System.out.println("Worker " + workerId + " started.");

                try {
                    Thread.sleep(1000 * workerId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                System.out.println("Worker " + workerId + " completed.");
                latch.countDown();
            });

            worker.start();
        }

        System.out.println("Main thread waiting...");

        try {
            latch.await();
            System.out.println("All workers completed. Main thread resumed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
