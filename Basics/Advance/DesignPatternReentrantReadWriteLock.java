import java.util.concurrent.locks.ReentrantReadWriteLock;

class RWLPlacementData {

    private String companyStatus = "Application Started";

    private final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();

    public void readStatus(String reader) {

        lock.readLock().lock();

        try {

            System.out.println(
                    reader
                    + " reading status: "
                    + companyStatus);

            Thread.sleep(500);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } finally {

            lock.readLock().unlock();
        }
    }

    public void updateStatus(
            String newStatus,
            String writer) {

        lock.writeLock().lock();

        try {

            System.out.println(
                    writer
                    + " updating status to: "
                    + newStatus);

            companyStatus = newStatus;

            Thread.sleep(1000);

            System.out.println(
                    writer + " completed update.");

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } finally {

            lock.writeLock().unlock();
        }
    }
}

public class DesignPatternReentrantReadWriteLock {

    public static void main(String[] args)
            throws InterruptedException {

        RWLPlacementData data =
                new RWLPlacementData();

        Thread reader1 = new Thread(() -> {
            data.readStatus("Reader-1");
        });

        Thread reader2 = new Thread(() -> {
            data.readStatus("Reader-2");
        });

        Thread reader3 = new Thread(() -> {
            data.readStatus("Reader-3");
        });

        Thread writer = new Thread(() -> {
            data.updateStatus(
                    "Technical Round",
                    "Writer");
        });

        reader1.start();
        reader2.start();
        reader3.start();

        reader1.join();
        reader2.join();
        reader3.join();

        writer.start();
        writer.join();

        System.out.println(
                "\nFinal read after update:");

        data.readStatus("Final Reader");
    }
}