
import java.util.concurrent.CyclicBarrier;

public class AdvancedCyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
            System.out.println("All players are ready. Game starts!")
        );

        for (int i = 1; i <= 3; i++) {
            final int playerId = i;

            new Thread(() -> {
                try {
                    System.out.println(
                        "Player " + playerId + " is getting ready."
                    );

                    Thread.sleep(playerId * 500L);

                    System.out.println(
                        "Player " + playerId + " reached the barrier."
                    );

                    barrier.await();

                    System.out.println(
                        "Player " + playerId + " starts playing."
                    );
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
