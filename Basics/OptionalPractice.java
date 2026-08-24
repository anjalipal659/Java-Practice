import java.util.Optional;

public class OptionalPractice {

    public static void main(String[] args) {

        // 1. Optional with value
        Optional<String> name = Optional.of("Anjali");

        System.out.println("Name: " + name.get());


        // 2. Check if value is present
        if (name.isPresent()) {
            System.out.println("Name is present");
        }


        // 3. Optional empty
        Optional<String> emptyName = Optional.empty();

        System.out.println(
                "Is empty present? " + emptyName.isPresent()
        );


        // 4. orElse()
        String result = emptyName.orElse("Unknown");

        System.out.println("Result: " + result);


        // 5. orElseGet()
        String result2 = emptyName.orElseGet(
                () -> "Default Name"
        );

        System.out.println("Result 2: " + result2);


        // 6. ifPresent()
        name.ifPresent(
                value -> System.out.println("Value: " + value)
        );


        // 7. Optional with Integer
        Optional<Integer> number = Optional.of(100);

        System.out.println("Number: " + number.orElse(0));


        // 8. Optional map()
        Optional<String> upperName =
                name.map(String::toUpperCase);

        System.out.println(
                "Uppercase: " + upperName.orElse("Unknown")
        );
    }
}