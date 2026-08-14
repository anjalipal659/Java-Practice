public class StringProblems {

    public static void main(String[] args) {

        // 1. Reverse a String
        String str = "Java";
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }

        System.out.println("Reverse = " + reverse);


        // 2. Check Palindrome
        String word = "madam";
        String rev = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            rev = rev + word.charAt(i);
        }

        if (word.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }


        // 3. Count Vowels
        String text = "programming";
        int vowels = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                vowels++;
            }
        }

        System.out.println("Vowels = " + vowels);


        // 4. Count Consonants
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if ((ch >= 'a' && ch <= 'z') &&
                !(ch == 'a' || ch == 'e' || ch == 'i' ||
                  ch == 'o' || ch == 'u')) {

                consonants++;
            }
        }

        System.out.println("Consonants = " + consonants);


        // 5. Count Digits
        String data = "java123";
        int digits = 0;

        for (int i = 0; i < data.length(); i++) {

            char ch = data.charAt(i);

            if (ch >= '0' && ch <= '9') {
                digits++;
            }
        }

        System.out.println("Digits = " + digits);


        // 6. Remove Spaces
        String sentence = "Java is easy";

        String noSpaces = sentence.replace(" ", "");

        System.out.println("Without spaces = " + noSpaces);


        // 7. Count Words
        String sentence2 = "Java is easy to learn";

        String[] words = sentence2.split(" ");

        System.out.println("Words = " + words.length);
    }
}