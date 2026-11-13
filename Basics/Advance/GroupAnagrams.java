import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            int[] count = new int[26];

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] words = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(words));
    }
}