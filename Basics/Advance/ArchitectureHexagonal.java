import java.util.ArrayList;
import java.util.List;

// PORT
interface PlacementRepositoryPort {
    void save(String company);
    List<String> findAll();
}

// ADAPTER
class InMemoryPlacementRepository implements PlacementRepositoryPort {

    private List<String> companies = new ArrayList<>();

    @Override
    public void save(String company) {
        companies.add(company);
    }

    @Override
    public List<String> findAll() {
        return companies;
    }
}

// CORE BUSINESS LOGIC
class PlacementService {

    private PlacementRepositoryPort repository;

    public PlacementService(PlacementRepositoryPort repository) {
        this.repository = repository;
    }

    public void applyForCompany(String company) {

        if (company == null || company.isEmpty()) {
            System.out.println("Company name cannot be empty.");
            return;
        }

        repository.save(company);
        System.out.println("Applied to: " + company);
    }

    public void showApplications() {

        System.out.println("\nPlacement Applications:");

        for (String company : repository.findAll()) {
            System.out.println("- " + company);
        }
    }
}

// APPLICATION ADAPTER
public class ArchitectureHexagonal {

    public static void main(String[] args) {

        PlacementRepositoryPort repository =
                new InMemoryPlacementRepository();

        PlacementService service =
                new PlacementService(repository);

        service.applyForCompany("TCS");
        service.applyForCompany("Infosys");
        service.applyForCompany("Cognizant");

        service.showApplications();
    }
}