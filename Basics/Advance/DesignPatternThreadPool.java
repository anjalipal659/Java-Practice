import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PlacementThreadPoolTask implements Runnable {

    private final int taskNumber;

    public PlacementThreadPoolTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {

        System.out.println(
                "Task-" + taskNumber
                + " started by "
                + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println(
                "Task-" + taskNumber
                + " completed");
    }
}

public class DesignPatternThreadPool {

    public static void main(String[] args)
            throws InterruptedException {

        // Only 3 threads will be available
        ExecutorService threadPool =
                Executors.newFixedThreadPool(3);

        System.out.println(
                "Submitting tasks...\n");

        for (int i = 1; i <= 6; i++) {

            threadPool.submit(
                    new PlacementThreadPoolTask(i));
        }

        threadPool.shutdown();

        System.out.println(
                "All tasks submitted.");

        while (!threadPool.isTerminated()) {

            Thread.sleep(200);
        }

        System.out.println(
                "\nAll tasks completed.");
    }
}