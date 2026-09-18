import java.util.ArrayList;
import java.util.List;

class UnitWorkCandidate {

    private int id;
    private String name;

    public UnitWorkCandidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Candidate ID: " + id + ", Name: " + name;
    }
}

class UnitWorkApplication {

    private int applicationId;
    private String company;

    public UnitWorkApplication(
            int applicationId, String company) {

        this.applicationId = applicationId;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Application ID: " + applicationId
                + ", Company: " + company;
    }
}

class PlacementUnitOfWork {

    private List<UnitWorkCandidate> candidates =
            new ArrayList<>();

    private List<UnitWorkApplication> applications =
            new ArrayList<>();

    public void registerCandidate(
            UnitWorkCandidate candidate) {

        candidates.add(candidate);
        System.out.println("Candidate added.");
    }

    public void addApplication(
            UnitWorkApplication application) {

        applications.add(application);
        System.out.println("Application added.");
    }

    public void commit() {

        System.out.println();
        System.out.println("Committing Unit of Work...");

        System.out.println("Candidates saved: "
                + candidates.size());

        System.out.println("Applications saved: "
                + applications.size());

        System.out.println("Transaction completed.");
    }

    public void rollback() {

        candidates.clear();
        applications.clear();

        System.out.println("Transaction rolled back.");
    }
}

public class DesignPatternUnitOfWork {

    public static void main(String[] args) {

        PlacementUnitOfWork unitOfWork =
                new PlacementUnitOfWork();

        unitOfWork.registerCandidate(
                new UnitWorkCandidate(
                        1, "Anjali"
                )
        );

        unitOfWork.addApplication(
                new UnitWorkApplication(
                        101, "TCS"
                )
        );

        unitOfWork.addApplication(
                new UnitWorkApplication(
                        102, "Infosys"
                )
        );

        unitOfWork.commit();
    }
}