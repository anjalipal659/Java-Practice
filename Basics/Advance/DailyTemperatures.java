import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previous = stack.pop();
                result[previous] = i - previous;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(
            Arrays.toString(dailyTemperatures(temperatures))
        );
    }
}