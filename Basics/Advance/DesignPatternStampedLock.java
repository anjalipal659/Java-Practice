
import java.util.concurrent.locks.StampedLock;

class PlacementScoreBoard {

    private double score = 75.5;

    private final StampedLock lock =
            new StampedLock();

    public void updateScore(double newScore) {

        long stamp = lock.writeLock();

        try {
            score = newScore;

            System.out.println(
                    "Score updated: " + score);

        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public double readScore() {

        long stamp = lock.tryOptimisticRead();

        double currentScore = score;

        if (!lock.validate(stamp)) {

            stamp = lock.readLock();

            try {
                currentScore = score;

            } finally {
                lock.unlockRead(stamp);
            }
        }

        return currentScore;
    }
}

public class DesignPatternStampedLock {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementScoreBoard board =
                new PlacementScoreBoard();

        Thread reader1 = new Thread(() -> {
            System.out.println(
                    "Reader-1 Score: "
                    + board.readScore());
        });

        Thread writer = new Thread(() -> {
            board.updateScore(92.0);
        });

        Thread reader2 = new Thread(() -> {
            System.out.println(
                    "Reader-2 Score: "
                    + board.readScore());
        });

        reader1.start();
        writer.start();
        reader2.start();

        reader1.join();
        writer.join();
        reader2.join();

        System.out.println(
                "\nFinal Score: "
                + board.readScore());
    }
}