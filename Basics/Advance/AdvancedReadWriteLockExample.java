
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AdvancedReadWriteLockExample {
    private static final ReadWriteLock lock =
            new ReentrantReadWriteLock();

    private static int score = 100;

    static void readScore(int studentId) {
        lock.readLock().lock();

        try {
            System.out.println(
                "Student " + studentId + " read score: " + score
            );
        } finally {
            lock.readLock().unlock();
        }
    }

    static void updateScore(int newScore) {
        lock.writeLock().lock();

        try {
            score = newScore;
            System.out.println("Score updated to: " + score);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        Thread reader1 = new Thread(() -> readScore(1));
        Thread reader2 = new Thread(() -> readScore(2));
        Thread writer = new Thread(() -> updateScore(150));

        reader1.start();
        reader2.start();
        writer.start();
    }
}
