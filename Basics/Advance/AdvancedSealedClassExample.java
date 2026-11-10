
sealed class PlacementRole
        permits DeveloperRole, TesterRole {

    public void showRole() {
        System.out.println("Placement Role");
    }
}

final class DeveloperRole extends PlacementRole {

    @Override
    public void showRole() {
        System.out.println("Java Developer");
    }
}

final class TesterRole extends PlacementRole {

    @Override
    public void showRole() {
        System.out.println("Software Tester");
    }
}

public class AdvancedSealedClassExample {

    public static void main(String[] args) {

        PlacementRole developer = new DeveloperRole();
        PlacementRole tester = new TesterRole();

        developer.showRole();
        tester.showRole();
    }
}
