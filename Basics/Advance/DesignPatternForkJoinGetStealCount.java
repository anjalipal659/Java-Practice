
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class PlacementStealTask extends RecursiveTask<Long> {

    private final int start;
    private final int end;

    PlacementStealTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if (end - start <= 100) {
            long sum = 0;

            for (int i = start; i < end; i++) {
                sum += i;
            }

            return sum;
        }

        int middle = start + (end - start) / 2;

        PlacementStealTask left =
                new PlacementStealTask(start, middle);

        PlacementStealTask right =
                new PlacementStealTask(middle, end);

        left.fork();

        long rightResult = right.compute();
        long leftResult = left.join();

        return leftResult + rightResult;
    }
}

public class DesignPatternForkJoinGetStealCount {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(4);

        try {
            long result = pool.invoke(
                    new PlacementStealTask(1, 10001)
            );

            System.out.println("Sum: " + result);
            System.out.println("Steal count: "
                    + pool.getStealCount());
        } finally {
            pool.shutdown();
        }
    }
}
