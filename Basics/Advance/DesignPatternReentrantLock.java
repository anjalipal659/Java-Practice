import java.util.concurrent.locks.ReentrantLock;

class RLApplicationCounter {

    private int applications = 0;

    private final ReentrantLock lock =
            new ReentrantLock();

    public void submitApplication(String student) {

        lock.lock();

        try {

            applications++;

            System.out.println(
                    student
                    + " submitted application. Total = "
                    + applications);

        } finally {

            lock.unlock();
        }
    }

    public int getTotalApplications() {
        return applications;
    }
}

public class DesignPatternReentrantLock {

    public static void main(String[] args)
            throws InterruptedException {

        RLApplicationCounter counter =
                new RLApplicationCounter();

        Thread student1 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                counter.submitApplication("Student-1");
            }
        });

        Thread student2 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                counter.submitApplication("Student-2");
            }
        });

        Thread student3 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {
                counter.submitApplication("Student-3");
            }
        });

        student1.start();
        student2.start();
        student3.start();

        student1.join();
        student2.join();
        student3.join();

        System.out.println(
                "\nFinal Applications = "
                + counter.getTotalApplications());
    }
}