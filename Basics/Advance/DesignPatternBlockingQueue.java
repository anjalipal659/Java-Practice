import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class PlacementTaskBlockingQueue {

    private final BlockingQueue<String> queue =
            new ArrayBlockingQueue<>(3);

    public void addTask(String task) throws InterruptedException {
        queue.put(task);
        System.out.println("Produced → " + task);
    }

    public String processTask() throws InterruptedException {
        String task = queue.take();
        System.out.println("Consumed → " + task);
        return task;
    }
}

public class DesignPatternBlockingQueue {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementTaskBlockingQueue taskQueue =
                new PlacementTaskBlockingQueue();

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 8; i++) {

                try {
                    taskQueue.addTask(
                            "Placement Task-" + i);

                    Thread.sleep(300);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 8; i++) {

                try {
                    Thread.sleep(700);

                    taskQueue.processTask();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "\nProducer and Consumer completed.");
    }
}