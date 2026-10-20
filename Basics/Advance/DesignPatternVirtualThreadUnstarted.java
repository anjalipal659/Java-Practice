
public class DesignPatternVirtualThreadUnstarted {

    public static void main(String[] args) throws InterruptedException {

        // Create a virtual thread without starting it
        Thread studyThread = Thread.ofVirtual()
                .name("Study-Thread")
                .unstarted(() -> {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " is studying Java"
                    );
                });

        System.out.println("Thread created but not started.");

        // Start the virtual thread manually
        studyThread.start();

        // Wait for the thread to finish
        studyThread.join();

        System.out.println("Study task completed.");
    }
}
