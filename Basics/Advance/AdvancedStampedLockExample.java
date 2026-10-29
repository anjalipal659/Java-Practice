
import java.util.concurrent.locks.StampedLock;

public class AdvancedStampedLockExample {
    private static final StampedLock lock = new StampedLock();

    private static int balance = 1000;

    static int getBalance() {
        long stamp = lock.tryOptimisticRead();
        int currentBalance = balance;

        if (!lock.validate(stamp)) {
            stamp = lock.readLock();

            try {
                currentBalance = balance;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        return currentBalance;
    }

    static void deposit(int amount) {
        long stamp = lock.writeLock();

        try {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        System.out.println("Initial balance: " + getBalance());

        deposit(500);

        System.out.println("Updated balance: " + getBalance());
    }
}
