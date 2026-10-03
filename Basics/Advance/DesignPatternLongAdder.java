
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.atomic.LongAccumulator;

public class DesignPatternLongAdder {

    public static void main(String[] args)
            throws InterruptedException {

        LongAdder totalApplications = new LongAdder();

        // Accumulator that calculates the maximum value
        LongAccumulator highestScore =
                new LongAccumulator(Long::max, 0);

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {

            final int threadNumber = i + 1;

            threads[i] = new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    totalApplications.increment();
                }

                int score = threadNumber * 15;

                highestScore.accumulate(score);

                System.out.println(
                        "Thread-" + threadNumber
                        + " completed.");
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(
                "\nTotal Applications: "
                + totalApplications.sum());

        System.out.println(
                "Highest Score: "
                + highestScore.get());
    }
}