
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class PlacementStudentProfile {

    private final String name;
    private final List<String> skills;

    public PlacementStudentProfile(
            String name,
            List<String> skills) {

        this.name = name;

        this.skills = Collections.unmodifiableList(
                new ArrayList<>(skills));
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public PlacementStudentProfile addSkill(
            String newSkill) {

        List<String> updatedSkills =
                new ArrayList<>(skills);

        updatedSkills.add(newSkill);

        return new PlacementStudentProfile(
                name, updatedSkills);
    }
}

public class DesignPatternCopyOnWrite {

    public static void main(String[] args) {

        List<String> initialSkills =
                new ArrayList<>();

        initialSkills.add("Java");
        initialSkills.add("SQL");

        PlacementStudentProfile original =
                new PlacementStudentProfile(
                        "Anjali", initialSkills);

        PlacementStudentProfile updated =
                original.addSkill("Spring Boot");

        System.out.println(
                "Original Profile: "
                + original.getSkills());

        System.out.println(
                "Updated Profile: "
                + updated.getSkills());

        System.out.println(
                "Same Object: "
                + (original == updated));
    }
}