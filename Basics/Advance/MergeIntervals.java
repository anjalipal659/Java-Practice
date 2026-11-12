
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) ->
                Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (result.isEmpty() ||
                    result.get(result.size() - 1)[1] < interval[0]) {

                result.add(new int[]{
                        interval[0], interval[1]
                });

            } else {

                int[] last = result.get(result.size() - 1);

                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
