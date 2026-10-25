
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class PlacementSumTask extends RecursiveTask<Integer> {

    private final int[] numbers;
    private final int start;
    private final int end;

    PlacementSumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= 2) {
            int sum = 0;

            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }

            return sum;
        }

        int middle = start + (end - start) / 2;

        PlacementSumTask left =
                new PlacementSumTask(numbers, start, middle);

        PlacementSumTask right =
                new PlacementSumTask(numbers, middle, end);

        left.fork();

        int rightResult = right.compute();
        int leftResult = left.join();

        return leftResult + rightResult;
    }
}

public class DesignPatternRecursiveTask {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50, 60};

        ForkJoinPool pool = new ForkJoinPool();

        try {
            int result = pool.invoke(
                    new PlacementSumTask(numbers, 0, numbers.length)
            );

            System.out.println("Array sum: " + result);
        } finally {
            pool.shutdown();
        }
    }
}
