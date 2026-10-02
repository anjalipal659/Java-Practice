
import java.util.concurrent.atomic.AtomicInteger;

class PlacementApplicationCounter {

    private final AtomicInteger count =
            new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public boolean updateIfExpected(
            int expected,
            int newValue) {

        return count.compareAndSet(
                expected,
                newValue);
    }
}

public class DesignPatternAtomicInteger {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementApplicationCounter counter =
                new PlacementApplicationCounter();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(
                "Total Applications: "
                + counter.getCount());

        boolean updated =
                counter.updateIfExpected(5000, 6000);

        System.out.println(
                "Conditional Update: " + updated);

        System.out.println(
                "Final Count: "
                + counter.getCount());
    }
}