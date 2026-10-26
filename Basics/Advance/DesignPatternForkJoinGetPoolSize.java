
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class PlacementPoolSizeTask extends RecursiveAction {
    private final CountDownLatch started;
    private final CountDownLatch release;

    PlacementPoolSizeTask(CountDownLatch started, CountDownLatch release) {
        this.started = started;
        this.release = release;
    }

    @Override
    protected void compute() {
        started.countDown();

        try {
            release.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DesignPatternForkJoinGetPoolSize {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(2);

        CountDownLatch started = new CountDownLatch(2);
        CountDownLatch release = new CountDownLatch(1);

        pool.execute(new PlacementPoolSizeTask(started, release));
        pool.execute(new PlacementPoolSizeTask(started, release));

        started.await();

        System.out.println("Pool size: " + pool.getPoolSize());
        System.out.println("Parallelism: " + pool.getParallelism());

        release.countDown();
        pool.shutdown();
    }
}
