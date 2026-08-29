public class WrapperClassPractice {

    public static void main(String[] args) {

        // 1. Primitive data types
        int number = 100;
        double price = 99.5;
        boolean status = true;
        char grade = 'A';

        System.out.println("Primitive int: " + number);
        System.out.println("Primitive double: " + price);
        System.out.println("Primitive boolean: " + status);
        System.out.println("Primitive char: " + grade);


        // 2. Wrapper classes
        Integer intObject = 100;
        Double doubleObject = 99.5;
        Boolean booleanObject = true;
        Character charObject = 'A';

        System.out.println("\nWrapper Objects:");
        System.out.println(intObject);
        System.out.println(doubleObject);
        System.out.println(booleanObject);
        System.out.println(charObject);


        // 3. Autoboxing
        int value = 50;
        Integer object = value;

        System.out.println("\nAutoboxing:");
        System.out.println(object);


        // 4. Unboxing
        Integer anotherObject = 75;
        int anotherValue = anotherObject;

        System.out.println("\nUnboxing:");
        System.out.println(anotherValue);


        // 5. String to Integer
        String textNumber = "123";

        int convertedNumber =
                Integer.parseInt(textNumber);

        System.out.println("\nString to int:");
        System.out.println(convertedNumber);


        // 6. String to Double
        String textPrice = "99.99";

        double convertedPrice =
                Double.parseDouble(textPrice);

        System.out.println("String to double:");
        System.out.println(convertedPrice);


        // 7. Integer to String
        int marks = 85;

        String marksText =
                Integer.toString(marks);

        System.out.println("Integer to String:");
        System.out.println(marksText);


        // 8. Useful Integer methods
        System.out.println("\nInteger methods:");

        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Min: " + Integer.MIN_VALUE);
    }
}