import java.util.concurrent.ConcurrentLinkedQueue;

class PlacementTaskQueue {

    private final ConcurrentLinkedQueue<String> queue =
            new ConcurrentLinkedQueue<>();

    public void addTask(String task) {
        queue.offer(task);
    }

    public String processTask() {
        return queue.poll();
    }

    public String viewNextTask() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class DesignPatternConcurrentLinkedQueue {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementTaskQueue taskQueue =
                new PlacementTaskQueue();

        Thread producer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                String task =
                        "Placement Task-" + i;

                taskQueue.addTask(task);

                System.out.println(
                        "Added → " + task);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread consumer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                String task = null;

                while (task == null) {
                    task = taskQueue.processTask();

                    if (task == null) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                }

                System.out.println(
                        "Processed → " + task);
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "\nQueue Empty: "
                + taskQueue.isEmpty());
    }
}