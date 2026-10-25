
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinTask;

class PlacementInvokeTask extends RecursiveAction {

    private final String taskName;

    PlacementInvokeTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    protected void compute() {
        System.out.println(
                taskName + " executed by "
                + Thread.currentThread().getName()
        );
    }
}

public class DesignPatternForkJoinTaskInvokeAll {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(2);

        try {
            PlacementInvokeTask javaTask =
                    new PlacementInvokeTask("Java Practice");

            PlacementInvokeTask dsaTask =
                    new PlacementInvokeTask("DSA Practice");

            PlacementInvokeTask sqlTask =
                    new PlacementInvokeTask("SQL Practice");

            pool.invoke(
                    ForkJoinTask.invokeAll(
                            javaTask, dsaTask, sqlTask
                    )
            );

            System.out.println("All tasks completed.");
        } finally {
            pool.shutdown();
        }
    }
}
