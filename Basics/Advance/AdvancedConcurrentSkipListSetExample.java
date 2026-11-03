
import java.util.concurrent.ConcurrentSkipListSet;

public class AdvancedConcurrentSkipListSetExample {
    public static void main(String[] args) {
        ConcurrentSkipListSet<Integer> scores =
                new ConcurrentSkipListSet<>();

        scores.add(85);
        scores.add(95);
        scores.add(75);
        scores.add(85);

        System.out.println("Sorted Scores: " + scores);
        System.out.println("Lowest Score: " + scores.first());
        System.out.println("Highest Score: " + scores.last());

        scores.remove(75);

        System.out.println("After Removal: " + scores);
    }
}
