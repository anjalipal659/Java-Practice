import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class PlacementFutureTask implements Callable<Integer> {

    private final int studentCount;

    public PlacementFutureTask(int studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println(
                "Calculating placement score...");

        Thread.sleep(1000);

        return studentCount * 10;
    }
}

public class DesignPatternFutureTask {

    public static void main(String[] args)
            throws Exception {

        FutureTask<Integer> futureTask =
                new FutureTask<>(
                        new PlacementFutureTask(8));

        Thread workerThread =
                new Thread(
                        futureTask,
                        "Placement-Worker");

        workerThread.start();

        System.out.println(
                "Main thread is doing other work...");

        Thread.sleep(500);

        System.out.println(
                "Main thread finished its work.");

        // Waits if result is not ready yet
        Integer result = futureTask.get();

        System.out.println(
                "Placement Score: " + result);

        System.out.println(
                "Task Completed: "
                + futureTask.isDone());
    }
}