
public class DesignPatternThreadLocalPractice {

    private static final ThreadLocal<String> currentUser =
            new ThreadLocal<>();

    private static void processApplication(String user) {

        currentUser.set(user);

        try {
            System.out.println(
                    Thread.currentThread().getName()
                    + " → User: " + currentUser.get());

        } finally {
            currentUser.remove();
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new Thread(
                () -> processApplication("Anjali"),
                "Thread-1");

        Thread t2 = new Thread(
                () -> processApplication("Riya"),
                "Thread-2");

        Thread t3 = new Thread(
                () -> processApplication("Priya"),
                "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All applications processed.");
    }
}