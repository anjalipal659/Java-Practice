public class IfElse {
    public static void main(String[] args) {

        int number = 10;

        // if
        if (number > 0) {
            System.out.println("Positive number");
        }

        // if-else
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        // else-if
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        // Largest of two numbers
        int a = 20;
        int b = 15;

        if (a > b) {
            System.out.println("a is greater");
        } else if (b > a) {
            System.out.println("b is greater");
        } else {
            System.out.println("Both are equal");
        }
    }
}