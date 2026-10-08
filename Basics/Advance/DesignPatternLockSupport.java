import java.util.concurrent.locks.LockSupport;

class PlacementThreadController {

    private Thread workerThread;

    public void setWorkerThread(Thread thread) {
        this.workerThread = thread;
    }

    public void startWork() {

        System.out.println(
                "Worker started.");

        System.out.println(
                "Worker is parking...");

        LockSupport.park();

        System.out.println(
                "Worker resumed.");

        System.out.println(
                "Worker completed task.");
    }

    public void resumeWorker() {

        System.out.println(
                "Controller is unparking worker.");

        LockSupport.unpark(workerThread);
    }
}

public class DesignPatternLockSupport {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementThreadController controller =
                new PlacementThreadController();

        Thread worker = new Thread(() -> {

            controller.startWork();

        });

        controller.setWorkerThread(worker);

        worker.start();

        Thread.sleep(2000);

        controller.resumeWorker();

        worker.join();

        System.out.println(
                "\nThread execution completed.");
    }
}