
public class DesignPatternVirtualThreadBuilder {

    public static void main(String[] args) throws InterruptedException {

        // Method 1: Create and start a virtual thread
        Thread thread1 = Thread.ofVirtual()
                .name("Study-Thread")
                .start(() -> {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " is studying Java"
                    );
                });

        // Method 2: Start a virtual thread directly
        Thread thread2 = Thread.startVirtualThread(() -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " is practicing DSA"
            );
        });

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        System.out.println("Both virtual threads completed.");
    }
}
