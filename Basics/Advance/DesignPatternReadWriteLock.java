import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class PlacementDataStore {

    private String placementStatus =
            "Preparation Started";

    private final ReadWriteLock lock =
            new ReentrantReadWriteLock();

    public void readStatus(String readerName) {

        lock.readLock().lock();

        try {

            System.out.println(
                    readerName
                    + " reading: "
                    + placementStatus);

            Thread.sleep(500);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } finally {

            lock.readLock().unlock();
        }
    }

    public void updateStatus(String newStatus) {

        lock.writeLock().lock();

        try {

            System.out.println(
                    "\nWriter updating status...");

            Thread.sleep(1000);

            placementStatus = newStatus;

            System.out.println(
                    "Status updated to: "
                    + placementStatus);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } finally {

            lock.writeLock().unlock();
        }
    }
}

public class DesignPatternReadWriteLock {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementDataStore store =
                new PlacementDataStore();

        Thread reader1 = new Thread(
                () -> store.readStatus("Reader-1"));

        Thread reader2 = new Thread(
                () -> store.readStatus("Reader-2"));

        Thread reader3 = new Thread(
                () -> store.readStatus("Reader-3"));

        Thread writer = new Thread(
                () -> store.updateStatus(
                        "Interview Preparation"));

        reader1.start();
        reader2.start();
        reader3.start();

        Thread.sleep(200);

        writer.start();

        reader1.join();
        reader2.join();
        reader3.join();
        writer.join();

        System.out.println(
                "\nAll operations completed.");
    }
}