import java.util.ArrayList;
import java.util.List;

class ServiceLayerCandidate {

    private int id;
    private String name;
    private double score;

    public ServiceLayerCandidate(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Score: " + score;
    }
}

interface ServiceLayerCandidateRepository {

    void save(ServiceLayerCandidate candidate);

    List<ServiceLayerCandidate> findAll();
}

class ServiceLayerInMemoryRepository
        implements ServiceLayerCandidateRepository {

    private List<ServiceLayerCandidate> candidates =
            new ArrayList<>();

    @Override
    public void save(ServiceLayerCandidate candidate) {
        candidates.add(candidate);
    }

    @Override
    public List<ServiceLayerCandidate> findAll() {
        return candidates;
    }
}

class ServiceLayerCandidateService {

    private ServiceLayerCandidateRepository repository;

    public ServiceLayerCandidateService(
            ServiceLayerCandidateRepository repository) {

        this.repository = repository;
    }

    public void registerCandidate(
            ServiceLayerCandidate candidate) {

        if (candidate.getScore() < 0 ||
                candidate.getScore() > 100) {

            System.out.println("Invalid score.");
            return;
        }

        repository.save(candidate);

        System.out.println(
                "Candidate registered successfully."
        );
    }

    public void showEligibleCandidates() {

        System.out.println("Eligible Candidates:");

        for (ServiceLayerCandidate candidate :
                repository.findAll()) {

            if (candidate.getScore() >= 60) {
                System.out.println(candidate);
            }
        }
    }
}

public class DesignPatternServiceLayer {

    public static void main(String[] args) {

        ServiceLayerCandidateRepository repository =
                new ServiceLayerInMemoryRepository();

        ServiceLayerCandidateService service =
                new ServiceLayerCandidateService(repository);

        service.registerCandidate(
                new ServiceLayerCandidate(
                        1, "Anjali", 85
                )
        );

        service.registerCandidate(
                new ServiceLayerCandidate(
                        2, "Rahul", 55
                )
        );

        service.registerCandidate(
                new ServiceLayerCandidate(
                        3, "Priya", 72
                )
        );

        System.out.println();

        service.showEligibleCandidates();
    }
}