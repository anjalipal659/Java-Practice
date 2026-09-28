import java.util.concurrent.Semaphore;

class PlacementSemaphoreService {

    private final Semaphore semaphore;

    public PlacementSemaphoreService(int maxConcurrentRequests) {

        semaphore =
                new Semaphore(maxConcurrentRequests);
    }

    public void processRequest(String request)
            throws InterruptedException {

        semaphore.acquire();

        try {

            System.out.println(
                    request + " → Processing");

            Thread.sleep(1000);

            System.out.println(
                    request + " → Completed");

        } finally {

            semaphore.release();
        }
    }
}

public class DesignPatternSemaphoreLimiter {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementSemaphoreService service =
                new PlacementSemaphoreService(3);

        Thread[] threads = new Thread[6];

        for (int i = 0; i < threads.length; i++) {

            final int requestNumber = i + 1;

            threads[i] = new Thread(() -> {

                try {

                    service.processRequest(
                            "Request-" + requestNumber);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                    System.out.println(
                            "Request-" + requestNumber
                            + " → Interrupted");
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {

            thread.join();
        }

        System.out.println(
                "\nAll requests completed.");
    }
}