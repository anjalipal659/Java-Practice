class CBCompanyService {

    private boolean serviceAvailable = false;

    public String getCompanyData() {

        if (!serviceAvailable) {
            throw new RuntimeException("Company service unavailable");
        }

        return "Company data received";
    }
}


class CBCircuitBreaker {

    private int failureCount = 0;
    private final int failureThreshold = 3;

    private String state = "CLOSED";

    public String call(CBCompanyService service) {

        // If circuit is OPEN, don't call the service
        if (state.equals("OPEN")) {
            return "Circuit OPEN: Request blocked.";
        }

        try {

            String result = service.getCompanyData();

            // Service succeeded
            failureCount = 0;
            state = "CLOSED";

            return result;

        } catch (Exception e) {

            failureCount++;

            System.out.println(
                    "Service failed. Failure count: "
                    + failureCount
            );

            // Open circuit after 3 failures
            if (failureCount >= failureThreshold) {

                state = "OPEN";

                System.out.println(
                        "Circuit changed to OPEN."
                );
            }

            return "Fallback: Company data temporarily unavailable.";
        }
    }

    public String getState() {
        return state;
    }
}


public class DesignPatternCircuitBreaker {

    public static void main(String[] args) {

        CBCompanyService service =
                new CBCompanyService();

        CBCircuitBreaker circuitBreaker =
                new CBCircuitBreaker();

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRequest " + i);

            String response =
                    circuitBreaker.call(service);

            System.out.println(response);

            System.out.println(
                    "Circuit State: "
                    + circuitBreaker.getState()
            );
        }
    }
}