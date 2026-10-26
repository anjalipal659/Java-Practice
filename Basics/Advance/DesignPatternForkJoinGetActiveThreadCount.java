
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class PlacementActiveCountTask extends RecursiveAction {
    private final CountDownLatch started;
    private final CountDownLatch release;

    PlacementActiveCountTask(CountDownLatch started, CountDownLatch release) {
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

public class DesignPatternForkJoinGetActiveThreadCount {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(2);

        CountDownLatch started = new CountDownLatch(2);
        CountDownLatch release = new CountDownLatch(1);

        pool.execute(new PlacementActiveCountTask(started, release));
        pool.execute(new PlacementActiveCountTask(started, release));

        started.await();

        System.out.println(
            "Active worker threads: " + pool.getActiveThreadCount()
        );

        release.countDown();
        pool.shutdown();
    }
}
