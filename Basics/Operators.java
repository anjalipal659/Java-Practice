public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // Arithmetic Operators
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        // Relational Operators
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);
        System.out.println(a != b);

        // Logical Operators
        System.out.println(a > 5 && b < 5);
        System.out.println(a > 15 || b < 5);
        System.out.println(!(a > b));
    }
}