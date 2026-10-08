import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class PlacementTaskCoordinator {

    private final ReentrantLock lock =
            new ReentrantLock();

    private final Condition taskAvailable =
            lock.newCondition();

    private String task;

    private boolean taskReady = false;

    public void produceTask(String newTask)
            throws InterruptedException {

        lock.lock();

        try {

            while (taskReady) {
                taskAvailable.await();
            }

            task = newTask;
            taskReady = true;

            System.out.println(
                    "Produced → " + task);

            taskAvailable.signal();

        } finally {

            lock.unlock();
        }
    }

    public void consumeTask()
            throws InterruptedException {

        lock.lock();

        try {

            while (!taskReady) {

                System.out.println(
                        "Consumer waiting for task...");

                taskAvailable.await();
            }

            System.out.println(
                    "Consumed → " + task);

            task = null;
            taskReady = false;

            taskAvailable.signal();

        } finally {

            lock.unlock();
        }
    }
}

public class DesignPatternCondition {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementTaskCoordinator coordinator =
                new PlacementTaskCoordinator();

        Thread producer = new Thread(() -> {

            String[] tasks = {
                    "DSA Practice",
                    "Coding Test",
                    "Mock Interview",
                    "Resume Update"
            };

            try {

                for (String task : tasks) {

                    coordinator.produceTask(task);

                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 4; i++) {

                    coordinator.consumeTask();

                    Thread.sleep(800);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "\nAll tasks processed successfully.");
    }
}