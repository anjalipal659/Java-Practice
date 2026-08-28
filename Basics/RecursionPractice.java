public class RecursionPractice {

    // 1. Print numbers from 1 to n
    static void printNumbers(int n) {

        if (n == 0) {
            return;
        }

        printNumbers(n - 1);

        System.out.println(n);
    }

    // 2. Factorial
    static int factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // 3. Sum of numbers from 1 to n
    static int sum(int n) {

        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

    // 4. Power
    static int power(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        }

        return base * power(base, exponent - 1);
    }

    // 5. Fibonacci
    static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        System.out.println("Numbers 1 to 5:");
        printNumbers(5);

        System.out.println("\nFactorial of 5:");
        System.out.println(factorial(5));

        System.out.println("\nSum of 1 to 5:");
        System.out.println(sum(5));

        System.out.println("\n2^5:");
        System.out.println(power(2, 5));

        System.out.println("\nFibonacci:");
        for (int i = 0; i < 8; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}