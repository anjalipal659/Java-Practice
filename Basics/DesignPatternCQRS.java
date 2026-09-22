import java.util.HashMap;
import java.util.Map;

// Model
class CQRSPlacementCandidate {
    private int id;
    private String name;
    private String status;

    public CQRSPlacementCandidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = "Not Applied";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Status: " + status;
    }
}

// Write side
class CandidateCommandService {

    private Map<Integer, CQRSPlacementCandidate> candidates = new HashMap<>();

    public void registerCandidate(int id, String name) {
        candidates.put(id, new CQRSPlacementCandidate(id, name));
        System.out.println("Candidate registered.");
    }

    public void updateStatus(int id, String status) {
        CQRSPlacementCandidate candidate = candidates.get(id);

        if (candidate != null) {
            candidate.setStatus(status);
            System.out.println("Status updated.");
        } else {
            System.out.println("Candidate not found.");
        }
    }

    public Map<Integer, CQRSPlacementCandidate> getData() {
        return candidates;
    }
}

// Read side
class CandidateQueryService {

    private Map<Integer, CQRSPlacementCandidate> candidates;

    public CandidateQueryService(
            Map<Integer, CQRSPlacementCandidate> candidates) {
        this.candidates = candidates;
    }

    public void findCandidate(int id) {
        CQRSPlacementCandidate candidate = candidates.get(id);

        if (candidate != null) {
            System.out.println(candidate);
        } else {
            System.out.println("Candidate not found.");
        }
    }

    public void showAllCandidates() {
        for (CQRSPlacementCandidate candidate : candidates.values()) {
            System.out.println(candidate);
        }
    }
}

// Main class
public class DesignPatternCQRS {

    public static void main(String[] args) {

        CandidateCommandService commandService =
                new CandidateCommandService();

        // COMMANDS
        commandService.registerCandidate(101, "Anjali");
        commandService.registerCandidate(102, "Rahul");

        commandService.updateStatus(101, "Interview Scheduled");

        System.out.println();

        // QUERY SIDE
        CandidateQueryService queryService =
                new CandidateQueryService(commandService.getData());

        System.out.println("Candidate 101:");
        queryService.findCandidate(101);

        System.out.println("\nAll Candidates:");
        queryService.showAllCandidates();
    }
}