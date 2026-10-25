
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.CountDownLatch;

class PlacementQueuedTask extends RecursiveAction {

    private final CountDownLatch latch;

    PlacementQueuedTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    protected void compute() {
        try {
            latch.await();
            System.out.println(
                    "Task executed by "
                    + Thread.currentThread().getName()
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DesignPatternForkJoinGetQueuedTaskCount {

    public static void main(String[] args)
            throws InterruptedException {

        ForkJoinPool pool = new ForkJoinPool(1);
        CountDownLatch latch = new CountDownLatch(1);

        try {
            for (int i = 0; i < 5; i++) {
                pool.execute(new PlacementQueuedTask(latch));
            }

            Thread.sleep(200);

            System.out.println("Queued tasks: "
                    + pool.getQueuedTaskCount());

            latch.countDown();

            pool.shutdown();

            if (!pool.awaitTermination(5, 
                    java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Tasks did not finish in time.");
                pool.shutdownNow();
            }
        } finally {
            if (!pool.isTerminated()) {
                latch.countDown();
                pool.shutdownNow();
            }
        }
    }
}
