
import java.util.concurrent.CountDownLatch;

class PlacementDataLoader implements Runnable {

    private final String serviceName;
    private final CountDownLatch latch;

    public PlacementDataLoader(
            String serviceName,
            CountDownLatch latch) {

        this.serviceName = serviceName;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            System.out.println(
                    serviceName + " loading...");

            Thread.sleep(1000);

            System.out.println(
                    serviceName + " loaded successfully.");

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } finally {
            latch.countDown();
        }
    }
}

public class DesignPatternCountDownLatch {

    public static void main(String[] args)
            throws InterruptedException {

        CountDownLatch latch =
                new CountDownLatch(3);

        Thread studyThread = new Thread(
                new PlacementDataLoader("Study Service", latch));

        Thread codingThread = new Thread(
                new PlacementDataLoader("Coding Service", latch));

        Thread companyThread = new Thread(
                new PlacementDataLoader("Company Service", latch));

        studyThread.start();
        codingThread.start();
        companyThread.start();

        System.out.println(
                "\nWaiting for all services...\n");

        latch.await();

        System.out.println(
                "\nAll services loaded!");

        System.out.println(
                "Placement Dashboard is ready.");
    }
}