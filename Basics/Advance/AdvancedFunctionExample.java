
import java.util.function.Function;

public class AdvancedFunctionExample {

    public static void main(String[] args) {

        Function<String, Integer> getLength =
                name -> name.length();

        Function<Integer, Integer> square =
                number -> number * number;

        String studentName = "Anjali";

        int length = getLength.apply(studentName);

        int result = square.apply(length);

        System.out.println("Student Name: " + studentName);
        System.out.println("Name Length: " + length);
        System.out.println("Square of Length: " + result);

        Function<String, Integer> combined =
                getLength.andThen(square);

        System.out.println(
                "Combined Result: " + combined.apply("Anjali")
        );
    }
}
