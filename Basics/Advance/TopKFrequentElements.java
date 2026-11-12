
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(
                    num,
                    frequency.getOrDefault(num, 0) + 1
            );
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<>((a, b) -> {

                    int comparison = Integer.compare(
                            frequency.get(a),
                            frequency.get(b)
                    );

                    if (comparison == 0) {
                        return Integer.compare(b, a);
                    }

                    return comparison;
                });

        for (int num : frequency.keySet()) {

            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = 2;

        System.out.println(
                "Top K Frequent Elements: " +
                Arrays.toString(topKFrequent(nums, k))
        );
    }
}
