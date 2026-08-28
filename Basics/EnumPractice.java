enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

enum Status {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}

public class EnumPractice {

    public static void main(String[] args) {

        // 1. Using enum
        Day today = Day.FRIDAY;

        System.out.println("Today: " + today);

        // 2. Switch with enum
        switch (today) {

            case MONDAY:
                System.out.println("Start of the week");
                break;

            case FRIDAY:
                System.out.println("Almost weekend!");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend");
                break;

            default:
                System.out.println("Working day");
        }

        // 3. Status enum
        Status taskStatus = Status.IN_PROGRESS;

        System.out.println("Task Status: " + taskStatus);

        // 4. values()
        System.out.println("\nAll Days:");

        for (Day day : Day.values()) {
            System.out.println(day);
        }

        // 5. valueOf()
        Day selectedDay = Day.valueOf("MONDAY");

        System.out.println("\nSelected Day: " + selectedDay);

        // 6. ordinal()
        System.out.println(
                "Position of MONDAY: " + Day.MONDAY.ordinal()
        );
    }
}