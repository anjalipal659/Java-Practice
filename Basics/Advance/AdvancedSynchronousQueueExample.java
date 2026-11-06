
import java.util.concurrent.SynchronousQueue;

public class AdvancedSynchronousQueueExample {

    public static void main(String[] args) {

        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                String message = "Java Placement Preparation";

                System.out.println("Producer: Sending message...");
                queue.put(message);

                System.out.println("Producer: Message transferred.");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000);

                System.out.println("Consumer: Waiting for message...");

                String message = queue.take();

                System.out.println("Consumer received: " + message);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
