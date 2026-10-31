
import java.util.concurrent.atomic.AtomicBoolean;

public class AdvancedAtomicBooleanExample {
    public static void main(String[] args) {

        AtomicBoolean applicationRunning = new AtomicBoolean(false);

        System.out.println(
            "Application Running: " + applicationRunning.get()
        );

        boolean started = applicationRunning.compareAndSet(false, true);

        System.out.println("Application Started: " + started);
        System.out.println(
            "Current Status: " + applicationRunning.get()
        );

        applicationRunning.set(false);

        System.out.println(
            "Application Stopped: " + !applicationRunning.get()
        );
    }
}
