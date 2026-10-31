
import java.util.concurrent.atomic.LongAdder;

public class AdvancedLongAdderExample {
    public static void main(String[] args) throws InterruptedException {

        LongAdder pageViews = new LongAdder();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                pageViews.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Total Page Views: " + pageViews.sum());
    }
}
