
import java.util.concurrent.atomic.DoubleAccumulator;

public class AdvancedDoubleAccumulatorExample {
    public static void main(String[] args) throws InterruptedException {
        DoubleAccumulator maximum =
                new DoubleAccumulator(Math::max, Double.NEGATIVE_INFINITY);

        double[] temperatures = {31.5, 36.2, 29.8, 38.4, 34.1};
        Thread[] threads = new Thread[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            final double temperature = temperatures[i];

            threads[i] = new Thread(
                    () -> maximum.accumulate(temperature)
            );
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Maximum temperature: " + maximum.get());
    }
}
