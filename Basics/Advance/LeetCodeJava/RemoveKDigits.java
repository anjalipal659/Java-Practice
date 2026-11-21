package LeetCodeJava;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }

        char[] stack = new char[num.length()];
        int top = -1;

        for (int i = 0; i < num.length(); i++) {

            char current = num.charAt(i);

            while (top >= 0 && k > 0
                    && stack[top] > current) {
                top--;
                k--;
            }

            stack[++top] = current;
        }

        top -= k;

        int start = 0;

        while (start <= top && stack[start] == '0') {
            start++;
        }

        if (start > top) {
            return "0";
        }

        return new String(stack, start, top - start + 1);
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        System.out.println("Smallest number: "
                + removeKdigits(num, k));
    }
}