
import java.util.concurrent.atomic.LongAccumulator;

public class AdvancedLongAccumulatorExample {
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator maximum =
                new LongAccumulator(Long::max, Long.MIN_VALUE);

        long[] values = {45, 89, 23, 100, 67};

        Thread[] threads = new Thread[values.length];

        for (int i = 0; i < values.length; i++) {
            final long value = values[i];

            threads[i] = new Thread(() -> maximum.accumulate(value));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Maximum Value: " + maximum.get());
    }
}
