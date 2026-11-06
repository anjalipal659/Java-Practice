
import java.util.concurrent.PriorityBlockingQueue;

public class AdvancedPriorityBlockingQueueExample {
    public static void main(String[] args) {
        PriorityBlockingQueue<Integer> tasks =
                new PriorityBlockingQueue<>();

        tasks.offer(30);
        tasks.offer(10);
        tasks.offer(20);
        tasks.offer(5);

        System.out.println("Tasks in Priority Queue:");

        while (!tasks.isEmpty()) {
            System.out.println("Processing: " + tasks.poll());
        }
    }
}
