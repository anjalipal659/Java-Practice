import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class PlacementDelayedTask implements Delayed {

    private final String task;
    private final long executeAt;

    public PlacementDelayedTask(
            String task,
            long delay,
            TimeUnit unit) {

        this.task = task;

        this.executeAt =
                System.nanoTime()
                + unit.toNanos(delay);
    }

    public String getTask() {
        return task;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        long remaining =
                executeAt - System.nanoTime();

        return unit.convert(
                remaining,
                TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {

        return Long.compare(
                this.getDelay(TimeUnit.NANOSECONDS),
                other.getDelay(TimeUnit.NANOSECONDS));
    }
}

public class DesignPatternDelayQueue {

    public static void main(String[] args)
            throws InterruptedException {

        DelayQueue<PlacementDelayedTask> queue =
                new DelayQueue<>();

        queue.put(
                new PlacementDelayedTask(
                        "Interview Reminder",
                        2,
                        TimeUnit.SECONDS));

        queue.put(
                new PlacementDelayedTask(
                        "Coding Test Reminder",
                        4,
                        TimeUnit.SECONDS));

        queue.put(
                new PlacementDelayedTask(
                        "Application Follow-up",
                        6,
                        TimeUnit.SECONDS));

        System.out.println(
                "Tasks added to DelayQueue.");

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 3; i++) {

                    PlacementDelayedTask task =
                            queue.take();

                    System.out.println(
                            "Processing → "
                            + task.getTask());
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        long startTime = System.currentTimeMillis();

        consumer.start();
        consumer.join();

        long totalTime =
                System.currentTimeMillis() - startTime;

        System.out.println(
                "\nAll delayed tasks processed.");

        System.out.println(
                "Processing time: "
                + (totalTime / 1000.0)
                + " seconds");
    }
}