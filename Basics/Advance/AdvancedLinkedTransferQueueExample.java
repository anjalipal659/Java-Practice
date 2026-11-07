
import java.util.concurrent.LinkedTransferQueue;

public class AdvancedLinkedTransferQueueExample {

    public static void main(String[] args) {

        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: Sending data...");
                queue.transfer("Java Advanced Programming");
                System.out.println("Producer: Data received by consumer.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000);

                String data = queue.take();
                System.out.println("Consumer received: " + data);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
