import java.util.ArrayList;
import java.util.List;

class PlacementCandidate {

    private int id;
    private String name;

    public PlacementCandidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

interface CandidateRepository {

    void save(PlacementCandidate candidate);

    PlacementCandidate findById(int id);

    List<PlacementCandidate> findAll();
}

class InMemoryCandidateRepository implements CandidateRepository {

    private List<PlacementCandidate> candidates =
            new ArrayList<>();

    @Override
    public void save(PlacementCandidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate saved.");
    }

    @Override
    public PlacementCandidate findById(int id) {

        for (PlacementCandidate candidate : candidates) {

            if (candidate.getId() == id) {
                return candidate;
            }
        }

        return null;
    }

    @Override
    public List<PlacementCandidate> findAll() {
        return candidates;
    }
}

public class DesignPatternRepository {

    public static void main(String[] args) {

        CandidateRepository repository =
                new InMemoryCandidateRepository();

        repository.save(
                new PlacementCandidate(1, "Anjali")
        );

        repository.save(
                new PlacementCandidate(2, "Rahul")
        );

        System.out.println();

        System.out.println("All Candidates:");

        for (PlacementCandidate candidate :
                repository.findAll()) {

            System.out.println(candidate);
        }

        System.out.println();

        PlacementCandidate candidate =
                repository.findById(1);

        if (candidate != null) {
            System.out.println("Found: " + candidate);
        } else {
            System.out.println("Candidate not found.");
        }
    }
}