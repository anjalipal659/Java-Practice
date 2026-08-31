import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static void main(String[] args) {

        // 1. Check email
        String email = "anjali@gmail.com";

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        System.out.println(
                "Valid Email: "
                        + email.matches(emailRegex)
        );


        // 2. Check mobile number
        String mobile = "9876543210";

        String mobileRegex = "^[6-9][0-9]{9}$";

        System.out.println(
                "Valid Mobile: "
                        + mobile.matches(mobileRegex)
        );


        // 3. Check only digits
        String number = "123456";

        System.out.println(
                "Only Digits: "
                        + number.matches("[0-9]+")
        );


        // 4. Check only alphabets
        String name = "Anjali";

        System.out.println(
                "Only Alphabets: "
                        + name.matches("[A-Za-z]+")
        );


        // 5. Find Java words from text
        String text =
                "Java is powerful. I am learning Java programming.";

        Pattern pattern =
                Pattern.compile("Java");

        Matcher matcher =
                pattern.matcher(text);

        System.out.println("\nJava found at:");

        while (matcher.find()) {
            System.out.println(
                    "Start: " + matcher.start()
                            + ", End: " + matcher.end()
            );
        }


        // 6. Replace numbers
        String data =
                "My marks are 85 and my age is 21.";

        String result =
                data.replaceAll("[0-9]+", "NUMBER");

        System.out.println("\nAfter replacing numbers:");
        System.out.println(result);
    }
}