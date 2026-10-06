import java.util.concurrent.PriorityBlockingQueue;

class PlacementPriorityTask
        implements Comparable<PlacementPriorityTask> {

    private final String task;
    private final int priority;

    public PlacementPriorityTask(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PlacementPriorityTask other) {
        return Integer.compare(
                this.priority,
                other.priority
        );
    }

    @Override
    public String toString() {
        return task + " | Priority: " + priority;
    }
}

public class DesignPatternPriorityBlockingQueue {

    public static void main(String[] args)
            throws InterruptedException {

        PriorityBlockingQueue<PlacementPriorityTask> queue =
                new PriorityBlockingQueue<>();

        Thread producer = new Thread(() -> {

            queue.add(
                    new PlacementPriorityTask(
                            "Normal Coding Practice", 3));

            queue.add(
                    new PlacementPriorityTask(
                            "Interview Preparation", 1));

            queue.add(
                    new PlacementPriorityTask(
                            "Resume Update", 2));

            queue.add(
                    new PlacementPriorityTask(
                            "DSA Practice", 2));

            queue.add(
                    new PlacementPriorityTask(
                            "Urgent Company Test", 1));

            System.out.println("All tasks added.");
        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= 5; i++) {

                    PlacementPriorityTask task =
                            queue.take();

                    System.out.println(
                            "Processing → " + task);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        producer.join();

        consumer.start();
        consumer.join();

        System.out.println(
                "\nAll priority tasks processed.");
    }
}