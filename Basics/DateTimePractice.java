import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimePractice {

    public static void main(String[] args) {

        // 1. Current date
        LocalDate date = LocalDate.now();

        System.out.println("Current Date: " + date);

        // 2. Current time
        LocalTime time = LocalTime.now();

        System.out.println("Current Time: " + time);

        // 3. Current date and time
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("Date & Time: " + dateTime);

        // 4. Get date parts
        System.out.println("Year: " + date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDayOfMonth());

        // 5. Add days
        LocalDate futureDate = date.plusDays(10);

        System.out.println("After 10 days: " + futureDate);

        // 6. Subtract days
        LocalDate previousDate = date.minusDays(10);

        System.out.println("10 days before: " + previousDate);

        // 7. Custom date format
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(
                "Formatted Date: " + date.format(formatter)
        );

        // 8. Custom date and time format
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(
                "Formatted Date & Time: "
                        + dateTime.format(dateTimeFormatter)
        );
    }
}