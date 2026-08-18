public class ExceptionHandling {

    public static void main(String[] args) {

        // 1. Basic try-catch
        try {
            int a = 10;
            int b = 0;

            int result = a / b;

            System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }


        // 2. Array exception
        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index");
        }


        // 3. Finally
        try {
            int number = 10 / 2;
            System.out.println("Result = " + number);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");

        } finally {
            System.out.println("Finally block executed");
        }


        // 4. Multiple catch
        try {
            int[] arr = {10, 20, 30};

            int result = arr[5] / 0;

            System.out.println(result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error");
        }
    }
}