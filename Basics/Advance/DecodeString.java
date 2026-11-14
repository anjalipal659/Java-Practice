import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current = "";
            }
            else if (ch == ']') {
                int repeat = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder decoded = new StringBuilder(previous);

                for (int j = 0; j < repeat; j++) {
                    decoded.append(current);
                }

                current = decoded.toString();
            }
            else {
                current += ch;
            }
        }

        return current;
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";

        System.out.println("Decoded string: " + decodeString(input));
    }
}