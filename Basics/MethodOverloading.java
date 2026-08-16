class Calculator {

    // Two integers
    int add(int a, int b) {
        return a + b;
    }

    // Three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Two double values
    double add(double a, double b) {
        return a + b;
    }

    // Different parameter type
    int add(int a, double b) {
        return (int) (a + b);
    }
}

public class MethodOverloading {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println(calculator.add(10, 20));

        System.out.println(calculator.add(10, 20, 30));

        System.out.println(calculator.add(10.5, 20.5));

        System.out.println(calculator.add(10, 5.5));
    }
}