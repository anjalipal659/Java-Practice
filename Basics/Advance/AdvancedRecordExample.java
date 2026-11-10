
record PlacementStudentRecord(
        int id,
        String name,
        String role
) {}

public class AdvancedRecordExample {

    public static void main(String[] args) {

        PlacementStudentRecord student =
                new PlacementStudentRecord(
                        101, "Anjali", "Java Developer"
                );

        System.out.println("ID: " + student.id());
        System.out.println("Name: " + student.name());
        System.out.println("Role: " + student.role());

        System.out.println("Student: " + student);
    }
}
