import java.util.ArrayList;
import java.util.List;

class PlacementSpecificationCandidate {

    private String name;
    private double cgpa;
    private int testScore;

    public PlacementSpecificationCandidate(
            String name, double cgpa, int testScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.testScore = testScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getTestScore() {
        return testScore;
    }

    @Override
    public String toString() {
        return name +
                " | CGPA: " + cgpa +
                " | Test Score: " + testScore;
    }
}

interface CandidateSpecification {

    boolean isSatisfiedBy(
            PlacementSpecificationCandidate candidate);
}

class MinimumCGPASpecification
        implements CandidateSpecification {

    private double minimumCgpa;

    public MinimumCGPASpecification(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    @Override
    public boolean isSatisfiedBy(
            PlacementSpecificationCandidate candidate) {

        return candidate.getCgpa() >= minimumCgpa;
    }
}

class MinimumTestScoreSpecification
        implements CandidateSpecification {

    private int minimumScore;

    public MinimumTestScoreSpecification(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    @Override
    public boolean isSatisfiedBy(
            PlacementSpecificationCandidate candidate) {

        return candidate.getTestScore() >= minimumScore;
    }
}

class AndSpecification
        implements CandidateSpecification {

    private CandidateSpecification first;
    private CandidateSpecification second;

    public AndSpecification(
            CandidateSpecification first,
            CandidateSpecification second) {

        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfiedBy(
            PlacementSpecificationCandidate candidate) {

        return first.isSatisfiedBy(candidate)
                && second.isSatisfiedBy(candidate);
    }
}

public class DesignPatternSpecification {

    public static void main(String[] args) {

        List<PlacementSpecificationCandidate> candidates =
                new ArrayList<>();

        candidates.add(
                new PlacementSpecificationCandidate(
                        "Anjali", 8.4, 85
                )
        );

        candidates.add(
                new PlacementSpecificationCandidate(
                        "Rahul", 6.8, 75
                )
        );

        candidates.add(
                new PlacementSpecificationCandidate(
                        "Priya", 7.5, 55
                )
        );

        CandidateSpecification cgpaRule =
                new MinimumCGPASpecification(7.0);

        CandidateSpecification scoreRule =
                new MinimumTestScoreSpecification(60);

        CandidateSpecification placementRule =
                new AndSpecification(cgpaRule, scoreRule);

        System.out.println("Eligible Candidates:");

        for (PlacementSpecificationCandidate candidate :
                candidates) {

            if (placementRule.isSatisfiedBy(candidate)) {
                System.out.println(candidate);
            }
        }
    }
}