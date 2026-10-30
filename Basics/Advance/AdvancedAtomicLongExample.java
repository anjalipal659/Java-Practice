
import java.util.concurrent.atomic.AtomicLong;

public class AdvancedAtomicLongExample {
    public static void main(String[] args) throws InterruptedException {

        AtomicLong totalSales = new AtomicLong(0);

        Runnable salesTask = () -> {
            for (int i = 0; i < 1000; i++) {
                totalSales.addAndGet(100);
            }
        };

        Thread t1 = new Thread(salesTask);
        Thread t2 = new Thread(salesTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total Sales: " + totalSales.get());
    }
}
