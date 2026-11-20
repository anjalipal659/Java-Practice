package LeetCodeJava;
public class PermutationInString {


    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {

            if (matches(count1, count2)) {
                return true;
            }

            if (i + s1.length() < s2.length()) {
                count2[s2.charAt(i) - 'a']--;
                count2[s2.charAt(i + s1.length()) - 'a']++;
            }
        }

        return false;
    }

    public static boolean matches(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println("Permutation exists: "
                + checkInclusion(s1, s2));
    }
}