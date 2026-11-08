
import java.util.EnumMap;
import java.util.Map;

public class AdvancedEnumMapExample {

    enum PlacementStatus {
        APPLIED,
        TEST,
        INTERVIEW,
        SELECTED,
        REJECTED
    }

    public static void main(String[] args) {

        Map<PlacementStatus, String> companies =
                new EnumMap<>(PlacementStatus.class);

        companies.put(PlacementStatus.APPLIED, "TCS");
        companies.put(PlacementStatus.TEST, "Infosys");
        companies.put(PlacementStatus.INTERVIEW, "Wipro");
        companies.put(PlacementStatus.SELECTED, "Accenture");

        System.out.println("Placement Status:");

        for (Map.Entry<PlacementStatus, String> entry
                : companies.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println(
                "Selected company: "
                        + companies.get(PlacementStatus.SELECTED)
        );
    }
}
