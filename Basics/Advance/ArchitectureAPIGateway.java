// STUDY SERVICE
class GatewayStudyService {

    public void handleRequest() {
        System.out.println("Study Service: Study data fetched.");
    }
}

// COMPANY SERVICE
class GatewayCompanyService {

    public void handleRequest() {
        System.out.println("Company Service: Company data fetched.");
    }
}

// CODING SERVICE
class GatewayCodingService {

    public void handleRequest() {
        System.out.println("Coding Service: Coding data fetched.");
    }
}

// API GATEWAY
class PlacementAPIGateway {

    private GatewayStudyService studyService;
    private GatewayCompanyService companyService;
    private GatewayCodingService codingService;

    public PlacementAPIGateway() {
        studyService = new GatewayStudyService();
        companyService = new GatewayCompanyService();
        codingService = new GatewayCodingService();
    }

    public void routeRequest(String request) {

        switch (request) {

            case "study":
                studyService.handleRequest();
                break;

            case "company":
                companyService.handleRequest();
                break;

            case "coding":
                codingService.handleRequest();
                break;

            default:
                System.out.println("Invalid API request.");
        }
    }
}

// MAIN
public class ArchitectureAPIGateway {

    public static void main(String[] args) {

        PlacementAPIGateway gateway =
                new PlacementAPIGateway();

        System.out.println("API Gateway Started\n");

        gateway.routeRequest("study");
        gateway.routeRequest("company");
        gateway.routeRequest("coding");
        gateway.routeRequest("unknown");
    }
}