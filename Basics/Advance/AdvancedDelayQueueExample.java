
import java.util.concurrent.Delayed;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

class PlacementDelayedTask implements Delayed {

    private final String taskName;
    private final long expireTime;

    public PlacementDelayedTask(String taskName, long delayMillis) {
        this.taskName = taskName;
        this.expireTime = System.nanoTime()
                + TimeUnit.MILLISECONDS.toNanos(delayMillis);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remainingTime = expireTime - System.nanoTime();
        return unit.convert(remainingTime, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(
                this.getDelay(TimeUnit.NANOSECONDS),
                other.getDelay(TimeUnit.NANOSECONDS)
        );
    }

    public String getTaskName() {
        return taskName;
    }
}

public class AdvancedDelayQueueExample {

    public static void main(String[] args) {

        DelayQueue<PlacementDelayedTask> tasks = new DelayQueue<>();

        tasks.put(new PlacementDelayedTask("Task A", 3000));
        tasks.put(new PlacementDelayedTask("Task B", 1000));
        tasks.put(new PlacementDelayedTask("Task C", 2000));

        System.out.println("Processing delayed tasks:");

        while (!tasks.isEmpty()) {
            try {
                PlacementDelayedTask task = tasks.take();

                System.out.println(
                        task.getTaskName() + " executed at "
                                + System.currentTimeMillis()
                );

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task processing interrupted.");
                break;
            }
        }

        System.out.println("All tasks completed.");
    }
}
