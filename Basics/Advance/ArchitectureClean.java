import java.util.ArrayList;
import java.util.List;

// ENTITY
class CleanPlacementApplication {

    private String company;
    private String status;

    public CleanPlacementApplication(String company) {
        this.company = company;
        this.status = "Applied";
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}

// REPOSITORY INTERFACE
interface CleanPlacementRepository {

    void save(CleanPlacementApplication application);

    List<CleanPlacementApplication> findAll();
}

// REPOSITORY IMPLEMENTATION
class InMemoryCleanPlacementRepository
        implements CleanPlacementRepository {

    private List<CleanPlacementApplication> applications =
            new ArrayList<>();

    @Override
    public void save(CleanPlacementApplication application) {
        applications.add(application);
    }

    @Override
    public List<CleanPlacementApplication> findAll() {
        return applications;
    }
}

// USE CASE
class ApplyForPlacementUseCase {

    private CleanPlacementRepository repository;

    public ApplyForPlacementUseCase(
            CleanPlacementRepository repository) {
        this.repository = repository;
    }

    public void execute(String company) {

        if (company == null || company.isEmpty()) {
            System.out.println("Invalid company name.");
            return;
        }

        CleanPlacementApplication application =
                new CleanPlacementApplication(company);

        repository.save(application);

        System.out.println(
                "Application created for: " + company);
    }
}

// APPLICATION / UI LAYER
public class ArchitectureClean {

    public static void main(String[] args) {

        CleanPlacementRepository repository =
                new InMemoryCleanPlacementRepository();

        ApplyForPlacementUseCase useCase =
                new ApplyForPlacementUseCase(repository);

        useCase.execute("TCS");
        useCase.execute("Infosys");
        useCase.execute("Wipro");

        System.out.println("\nApplications:");

        for (CleanPlacementApplication application
                : repository.findAll()) {

            System.out.println(
                    application.getCompany()
                    + " -> "
                    + application.getStatus());
        }
    }
}