
import java.util.concurrent.Phaser;

class PlacementPhaseTask implements Runnable {

    private final String moduleName;
    private final Phaser phaser;

    public PlacementPhaseTask(
            String moduleName,
            Phaser phaser) {

        this.moduleName = moduleName;
        this.phaser = phaser;
    }

    @Override
    public void run() {

        for (int phase = 1; phase <= 3; phase++) {

            System.out.println(
                    moduleName
                    + " started Phase "
                    + phase);

            try {
                Thread.sleep(
                        (long) (Math.random() * 1500) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                phaser.arriveAndDeregister();
                return;
            }

            System.out.println(
                    moduleName
                    + " completed Phase "
                    + phase);

            phaser.arriveAndAwaitAdvance();
        }

        System.out.println(
                moduleName + " finished all phases.");

        phaser.arriveAndDeregister();
    }
}

public class DesignPatternPhaser {

    public static void main(String[] args)
            throws InterruptedException {

        Phaser phaser = new Phaser(3);

        Thread study = new Thread(
                new PlacementPhaseTask("Study Module", phaser));

        Thread coding = new Thread(
                new PlacementPhaseTask("Coding Module", phaser));

        Thread interview = new Thread(
                new PlacementPhaseTask("Interview Module", phaser));

        study.start();
        coding.start();
        interview.start();

        study.join();
        coding.join();
        interview.join();

        System.out.println(
                "\nAll modules completed successfully.");
    }
}