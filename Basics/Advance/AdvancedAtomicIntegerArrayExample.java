
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AdvancedAtomicIntegerArrayExample {
    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerArray scores = new AtomicIntegerArray(3);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                scores.incrementAndGet(0);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Student 1 Score: " + scores.get(0));
        System.out.println("Student 2 Score: " + scores.get(1));
        System.out.println("Student 3 Score: " + scores.get(2));
    }
}
