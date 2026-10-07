import java.util.concurrent.LinkedTransferQueue;

class PlacementTransferService {

    private final LinkedTransferQueue<String> queue =
            new LinkedTransferQueue<>();

    public void transferTask(String task)
            throws InterruptedException {

        System.out.println(
                "Producer preparing → " + task);

        queue.transfer(task);

        System.out.println(
                "Task transferred → " + task);
    }

    public String receiveTask()
            throws InterruptedException {

        String task = queue.take();

        System.out.println(
                "Consumer received → " + task);

        return task;
    }
}

public class DesignPatternLinkedTransferQueue {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementTransferService service =
                new PlacementTransferService();

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 4; i++) {

                    Thread.sleep(800);

                    service.receiveTask();
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        });

        Thread producer = new Thread(() -> {

            String[] tasks = {
                    "DSA Practice",
                    "Mock Interview",
                    "Coding Test",
                    "Resume Review"
            };

            try {

                for (String task : tasks) {

                    service.transferTask(task);

                    Thread.sleep(300);
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
                "\nAll tasks transferred successfully.");
    }
}