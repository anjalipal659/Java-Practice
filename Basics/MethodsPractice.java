public class MethodsPractice {

    // 1. Method without parameter and return value
    static void greet() {
        System.out.println("Hello, welcome to Java practice!");
    }

    // 2. Method with parameter
    static void printName(String name) {
        System.out.println("Name: " + name);
    }

    // 3. Method with return value
    static int add(int a, int b) {
        return a + b;
    }

    // 4. Method to check even
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // 5. Method to find maximum
    static int findMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 6. Method to calculate square
    static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {

        greet();

        printName("Anjali");

        int sum = add(10, 20);
        System.out.println("Sum: " + sum);

        System.out.println("Is 15 even? " + isEven(15));

        System.out.println("Maximum: " + findMax(25, 40));

        System.out.println("Square: " + square(7));
    }
}