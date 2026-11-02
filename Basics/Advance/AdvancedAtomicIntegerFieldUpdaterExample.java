
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

class PlacementStudent {
    volatile int completedTasks = 0;
}

public class AdvancedAtomicIntegerFieldUpdaterExample {
    private static final AtomicIntegerFieldUpdater<PlacementStudent> updater =
            AtomicIntegerFieldUpdater.newUpdater(
                    PlacementStudent.class, "completedTasks");

    public static void main(String[] args) throws InterruptedException {
        PlacementStudent student = new PlacementStudent();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                updater.incrementAndGet(student);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Completed Tasks: " + student.completedTasks);
    }
}
