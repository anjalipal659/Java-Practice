class RetryCompanyService {

    private int attempt = 0;

    public String fetchCompanyData() {

        attempt++;

        System.out.println("Service attempt: " + attempt);

        if (attempt < 3) {
            throw new RuntimeException("Temporary service failure");
        }

        return "Company data received successfully.";
    }
}


class PlacementRetryHandler {

    private int maxRetries;

    public PlacementRetryHandler(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public String execute(RetryCompanyService service) {

        for (int attempt = 1; attempt <= maxRetries; attempt++) {

            try {

                return service.fetchCompanyData();

            } catch (Exception e) {

                System.out.println(
                        "Attempt " + attempt + " failed."
                );

                if (attempt == maxRetries) {
                    return "All retry attempts failed.";
                }

                System.out.println("Retrying...");
                System.out.println();
            }
        }

        return "Request failed.";
    }
}


public class DesignPatternRetry {

    public static void main(String[] args) {

        RetryCompanyService service =
                new RetryCompanyService();

        PlacementRetryHandler retryHandler =
                new PlacementRetryHandler(3);

        String result = retryHandler.execute(service);

        System.out.println();
        System.out.println("Result:");
        System.out.println(result);
    }
}