package LeetCodeJava;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] count = new int[26];

        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']--;

            if (right - left + 1 > p.length()) {
                count[s.charAt(left) - 'a']++;
                left++;
            }

            if (right - left + 1 == p.length()) {
                boolean valid = true;

                for (int j = 0; j < 26; j++) {
                    if (count[j] != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    result.add(left);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}