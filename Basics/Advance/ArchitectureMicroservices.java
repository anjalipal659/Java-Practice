// STUDY SERVICE
class PlacementStudyService {

    public void trackStudy() {
        System.out.println("Study progress updated.");
    }
}

// COMPANY SERVICE
class PlacementCompanyService {

    public void addCompany(String company) {
        System.out.println(
                "Company added: " + company);
    }
}

// CODING SERVICE
class PlacementCodingService {

    public void trackCodingProblem(String problem) {
        System.out.println(
                "Coding problem completed: " + problem);
    }
}

// MAIN APPLICATION
public class ArchitectureMicroservices {

    public static void main(String[] args) {

        PlacementStudyService studyService =
                new PlacementStudyService();

        PlacementCompanyService companyService =
                new PlacementCompanyService();

        PlacementCodingService codingService =
                new PlacementCodingService();

        System.out.println("Placement Preparation System\n");

        studyService.trackStudy();

        companyService.addCompany("TCS");

        codingService.trackCodingProblem(
                "Two Sum");
    }
}