
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class DesignPatternAtomicLong {

    public static void main(String[] args)
            throws InterruptedException {

        AtomicLong totalApplications =
                new AtomicLong(0);

        AtomicLongArray companyApplications =
                new AtomicLongArray(3);

        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                totalApplications.incrementAndGet();
                companyApplications.incrementAndGet(0);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1500; i++) {
                totalApplications.incrementAndGet();
                companyApplications.incrementAndGet(1);
            }
        };

        Runnable task3 = () -> {
            for (int i = 0; i < 2000; i++) {
                totalApplications.incrementAndGet();
                companyApplications.incrementAndGet(2);
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(
                "Total Applications: "
                + totalApplications.get());

        System.out.println(
                "Company 1: "
                + companyApplications.get(0));

        System.out.println(
                "Company 2: "
                + companyApplications.get(1));

        System.out.println(
                "Company 3: "
                + companyApplications.get(2));

        // Add extra applications
        totalApplications.addAndGet(500);

        System.out.println(
                "\nUpdated Total: "
                + totalApplications.get());
    }
}