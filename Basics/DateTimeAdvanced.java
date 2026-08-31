import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeAdvanced {

    public static void main(String[] args) {

        // 1. Current date and time
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Current Time: " + currentTime);
        System.out.println("Date & Time: " + now);


        // 2. Create a specific date
        LocalDate birthDate =
                LocalDate.of(2005, 5, 6);

        System.out.println("\nBirth Date: " + birthDate);


        // 3. Date comparison
        if (today.isAfter(birthDate)) {
            System.out.println("Today is after birth date.");
        }

        if (today.isBefore(birthDate)) {
            System.out.println("Today is before birth date.");
        }


        // 4. Add and subtract date
        LocalDate after30Days =
                today.plusDays(30);

        LocalDate before30Days =
                today.minusDays(30);

        System.out.println("\nAfter 30 days: " + after30Days);
        System.out.println("Before 30 days: " + before30Days);


        // 5. Period between two dates
        LocalDate futureDate =
                LocalDate.of(2027, 5, 6);

        Period period =
                Period.between(birthDate, futureDate);

        System.out.println("\nPeriod:");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());


        // 6. Time difference
        LocalTime startTime =
                LocalTime.of(10, 30);

        LocalTime endTime =
                LocalTime.of(13, 45);

        Duration duration =
                Duration.between(startTime, endTime);

        System.out.println("\nTime Difference:");
        System.out.println("Hours: " + duration.toHours());
        System.out.println(
                "Minutes: " + duration.toMinutes()
        );


        // 7. Custom date format
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formattedDate =
                today.format(formatter);

        System.out.println("\nFormatted Date: "
                + formattedDate);


        // 8. Custom date and time format
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"
                );

        String formattedDateTime =
                now.format(dateTimeFormatter);

        System.out.println(
                "Formatted Date & Time: "
                        + formattedDateTime
        );


        // 9. Parse String into Date
        String dateText = "31-08-2026";

        LocalDate parsedDate =
                LocalDate.parse(
                        dateText,
                        formatter
                );

        System.out.println(
                "\nParsed Date: " + parsedDate
        );
    }
}