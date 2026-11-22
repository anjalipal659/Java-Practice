package LeetCodeJava;
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        int[] lastSeen = new int[128];

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            left = Math.max(left, lastSeen[ch]);

            maxLength = Math.max(maxLength, right - left + 1);

            lastSeen[ch] = right + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
