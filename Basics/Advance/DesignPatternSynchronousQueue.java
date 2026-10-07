import java.util.concurrent.SynchronousQueue;

class PlacementDirectHandoff {

    private final SynchronousQueue<String> queue =
            new SynchronousQueue<>();

    public void submitTask(String task)
            throws InterruptedException {

        System.out.println(
                "Producer waiting → " + task);

        queue.put(task);

        System.out.println(
                "Task handed to consumer → " + task);
    }

    public String receiveTask()
            throws InterruptedException {

        String task = queue.take();

        System.out.println(
                "Consumer received → " + task);

        return task;
    }
}

public class DesignPatternSynchronousQueue {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementDirectHandoff handoff =
                new PlacementDirectHandoff();

        Thread producer = new Thread(() -> {

            String[] tasks = {
                    "DSA Practice",
                    "Mock Interview",
                    "Coding Test",
                    "Resume Review"
            };

            try {

                for (String task : tasks) {

                    handoff.submitTask(task);

                    Thread.sleep(500);
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 4; i++) {

                    Thread.sleep(1000);

                    handoff.receiveTask();
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println(
                "\nDirect handoff completed.");
    }
}