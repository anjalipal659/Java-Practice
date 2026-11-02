
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

class PlacementStudyRecord {
    volatile long studyMinutes = 0;
}

public class AdvancedAtomicLongFieldUpdaterExample {
    private static final AtomicLongFieldUpdater<PlacementStudyRecord> updater =
            AtomicLongFieldUpdater.newUpdater(
                    PlacementStudyRecord.class, "studyMinutes");

    public static void main(String[] args) throws InterruptedException {
        PlacementStudyRecord record = new PlacementStudyRecord();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                updater.addAndGet(record, 5);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total Study Minutes: " + record.studyMinutes);
    }
}
