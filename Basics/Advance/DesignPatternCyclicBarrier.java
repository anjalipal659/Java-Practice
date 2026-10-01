
import java.util.concurrent.CyclicBarrier;

class PlacementModuleTask implements Runnable {

    private final String moduleName;
    private final CyclicBarrier barrier;

    public PlacementModuleTask(
            String moduleName,
            CyclicBarrier barrier) {

        this.moduleName = moduleName;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            System.out.println(
                    moduleName + " is preparing...");

            Thread.sleep(
                    (long) (Math.random() * 2000) + 500);

            System.out.println(
                    moduleName + " is ready.");

            barrier.await();

            System.out.println(
                    moduleName + " started the next phase.");

        } catch (Exception e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    moduleName + " was interrupted.");
        }
    }
}

public class DesignPatternCyclicBarrier {

    public static void main(String[] args)
            throws InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(
                3,
                () -> System.out.println(
                        "\nAll modules are ready. Starting next phase!\n")
        );

        Thread study = new Thread(
                new PlacementModuleTask("Study Module", barrier));

        Thread coding = new Thread(
                new PlacementModuleTask("Coding Module", barrier));

        Thread company = new Thread(
                new PlacementModuleTask("Company Module", barrier));

        study.start();
        coding.start();
        company.start();

        study.join();
        coding.join();
        company.join();

        System.out.println(
                "\nAll modules completed.");
    }
}