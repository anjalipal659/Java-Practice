public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        int[] frequency = new int[65536];

        // Count character frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch]++;
        }

        StringBuilder result = new StringBuilder();

        // Find the character with maximum frequency
        for (int i = 0; i < s.length(); i++) {

            int maxFrequency = 0;
            char maxChar = 0;

            for (int j = 0; j < frequency.length; j++) {

                if (frequency[j] > maxFrequency) {
                    maxFrequency = frequency[j];
                    maxChar = (char) j;
                }
            }

            if (maxFrequency == 0) {
                break;
            }

            // Append character according to frequency
            for (int j = 0; j < maxFrequency; j++) {
                result.append(maxChar);
            }

            frequency[maxChar] = 0;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String input = "tree";

        System.out.println("Sorted String: " + frequencySort(input));
    }
}