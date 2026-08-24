@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}

public class FunctionalInterfacePractice {

    public static void main(String[] args) {

        // Addition
        Calculator addition = (a, b) -> a + b;

        System.out.println("Addition: "
                + addition.calculate(10, 20));

        // Subtraction
        Calculator subtraction = (a, b) -> a - b;

        System.out.println("Subtraction: "
                + subtraction.calculate(20, 10));

        // Multiplication
        Calculator multiplication = (a, b) -> a * b;

        System.out.println("Multiplication: "
                + multiplication.calculate(10, 5));

        // Division
        Calculator division = (a, b) -> a / b;

        System.out.println("Division: "
                + division.calculate(20, 5));
    }
}