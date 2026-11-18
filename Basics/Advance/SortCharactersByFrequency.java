import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int oldCount = map.getOrDefault(ch, 0);
            map.put(ch, oldCount + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(b), map.get(a))
        );

        for (Character ch : map.keySet()) {
            pq.offer(ch);
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            char ch = pq.poll();
            int frequency = map.get(ch);

            for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "tree";

        System.out.println(frequencySort(input));
    }
}