import java.util.concurrent.ConcurrentSkipListSet;

class PlacementCandidateTracker {

    private final ConcurrentSkipListSet<String> candidates =
            new ConcurrentSkipListSet<>();

    public void addCandidate(String candidate) {
        candidates.add(candidate);
    }

    public void removeCandidate(String candidate) {
        candidates.remove(candidate);
    }

    public boolean containsCandidate(String candidate) {
        return candidates.contains(candidate);
    }

    public void displayCandidates() {
        candidates.forEach(
                candidate ->
                        System.out.println(candidate)
        );
    }

    public String getFirstCandidate() {
        return candidates.first();
    }

    public String getLastCandidate() {
        return candidates.last();
    }
}

public class DesignPatternConcurrentSkipListSet {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementCandidateTracker tracker =
                new PlacementCandidateTracker();

        Thread candidateThread1 = new Thread(() -> {

            tracker.addCandidate("Anjali");
            tracker.addCandidate("Riya");
            tracker.addCandidate("Priya");
            tracker.addCandidate("Anjali");
        });

        Thread candidateThread2 = new Thread(() -> {

            tracker.addCandidate("Rahul");
            tracker.addCandidate("Aman");
            tracker.addCandidate("Neha");
        });

        candidateThread1.start();
        candidateThread2.start();

        candidateThread1.join();
        candidateThread2.join();

        System.out.println("Candidates:");

        tracker.displayCandidates();

        System.out.println(
                "\nFirst Candidate → "
                + tracker.getFirstCandidate());

        System.out.println(
                "Last Candidate → "
                + tracker.getLastCandidate());

        System.out.println(
                "\nContains Anjali → "
                + tracker.containsCandidate("Anjali"));

        tracker.removeCandidate("Rahul");

        System.out.println(
                "\nAfter Removing Rahul:");

        tracker.displayCandidates();
    }
}