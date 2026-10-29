
import java.util.concurrent.Semaphore;

public class AdvancedSemaphoreExample {
    public static void main(String[] args) {
        Semaphore computers = new Semaphore(2);

        for (int i = 1; i <= 5; i++) {
            final int studentId = i;

            new Thread(() -> {
                try {
                    computers.acquire();

                    System.out.println(
                        "Student " + studentId + " is using a computer."
                    );

                    Thread.sleep(1000);

                    System.out.println(
                        "Student " + studentId + " released the computer."
                    );
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Release only if a permit was acquired.
                    // See the corrected version below for safe tracking.
                }
            }).start();
        }
    }
}
