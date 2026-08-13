public class Methods {

    // 1. Method without parameter and without return value
    static void greet() {
        System.out.println("Hello, Java!");
    }

    // 2. Method with parameter
    static void greetUser(String name) {
        System.out.println("Hello, " + name);
    }

    // 3. Method with two parameters
    static void printSum(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    // 4. Method with return value
    static int add(int a, int b) {
        return a + b;
    }

    // 5. Subtraction
    static int subtract(int a, int b) {
        return a - b;
    }

    // 6. Multiplication
    static int multiply(int a, int b) {
        return a * b;
    }

    // 7. Division
    static int divide(int a, int b) {
        return a / b;
    }

    // 8. Square
    static int square(int n) {
        return n * n;
    }

    // 9. Check Even or Odd
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // 10. Find Maximum
    static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 11. Find Minimum
    static int findMin(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // 12. Check Positive
    static boolean isPositive(int n) {
        return n > 0;
    }

    // 13. Print Table
    static void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    // 14. Calculate Factorial
    static int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    // Main method
    public static void main(String[] args) {

        greet();

        greetUser("Anjali");

        printSum(10, 20);

        System.out.println("Addition = " + add(10, 20));

        System.out.println("Subtraction = " + subtract(20, 10));

        System.out.println("Multiplication = " + multiply(5, 4));

        System.out.println("Division = " + divide(20, 5));

        System.out.println("Square = " + square(6));

        System.out.println("Is Even = " + isEven(10));

        System.out.println("Maximum = " + findMax(15, 25));

        System.out.println("Minimum = " + findMin(15, 25));

        System.out.println("Is Positive = " + isPositive(10));

        System.out.println("\nTable of 5:");
        printTable(5);

        System.out.println("\nFactorial = " + factorial(5));
    }
}