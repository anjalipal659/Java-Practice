
import java.util.concurrent.Phaser;

public class AdvancedPhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        for (int i = 1; i <= 2; i++) {
            final int studentId = i;

            new Thread(() -> {
                System.out.println("Student " + studentId + " is preparing");

                phaser.arriveAndAwaitAdvance();

                System.out.println("Student " + studentId + " started the test");

                phaser.arriveAndDeregister();
            }).start();
        }

        System.out.println("Main thread is preparing");
        phaser.arriveAndAwaitAdvance();
        System.out.println("Everyone is ready. Test started!");
        phaser.arriveAndDeregister();
    }
}
