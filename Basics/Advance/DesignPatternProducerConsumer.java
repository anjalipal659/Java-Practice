import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class PlacementTaskProducer implements Runnable {

    private final BlockingQueue<String> taskQueue;

    public PlacementTaskProducer(
            BlockingQueue<String> taskQueue) {

        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i <= 5; i++) {

                String task =
                        "Placement Task-" + i;

                taskQueue.put(task);

                System.out.println(
                        "Produced → " + task);

                Thread.sleep(500);
            }

            // Signal consumer that production is complete
            taskQueue.put("END");

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Producer interrupted.");
        }
    }
}

class PlacementTaskConsumer implements Runnable {

    private final BlockingQueue<String> taskQueue;

    public PlacementTaskConsumer(
            BlockingQueue<String> taskQueue) {

        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {

        try {

            while (true) {

                String task = taskQueue.take();

                if (task.equals("END")) {
                    break;
                }

                System.out.println(
                        "Consumed → " + task);

                Thread.sleep(800);
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Consumer interrupted.");
        }
    }
}

public class DesignPatternProducerConsumer {

    public static void main(String[] args)
            throws InterruptedException {

        BlockingQueue<String> taskQueue =
                new LinkedBlockingQueue<>(3);

        Thread producer =
                new Thread(
                        new PlacementTaskProducer(taskQueue));

        Thread consumer =
                new Thread(
                        new PlacementTaskConsumer(taskQueue));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "\nAll tasks processed.");
    }
}