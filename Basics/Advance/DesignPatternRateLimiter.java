class PlacementRateLimiter {

    private int requestCount = 0;

    private final int maxRequests;
    private final long timeWindowMillis;

    private long windowStartTime;

    public PlacementRateLimiter(
            int maxRequests,
            long timeWindowMillis) {

        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;

        this.windowStartTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {

        long currentTime = System.currentTimeMillis();

        // Start a new time window
        if (currentTime - windowStartTime
                >= timeWindowMillis) {

            requestCount = 0;
            windowStartTime = currentTime;
        }

        // Check request limit
        if (requestCount < maxRequests) {

            requestCount++;

            return true;
        }

        return false;
    }
}


public class DesignPatternRateLimiter {

    public static void main(String[] args)
            throws InterruptedException {

        // Allow 3 requests every 5 seconds
        PlacementRateLimiter rateLimiter =
                new PlacementRateLimiter(3, 5000);

        for (int i = 1; i <= 6; i++) {

            if (rateLimiter.allowRequest()) {

                System.out.println(
                        "Request " + i + " → Allowed");

            } else {

                System.out.println(
                        "Request " + i
                        + " → Rate Limit Exceeded");
            }

            Thread.sleep(500);
        }

        System.out.println(
                "\nWaiting for new time window...");

        Thread.sleep(5000);

        if (rateLimiter.allowRequest()) {

            System.out.println(
                    "New Request → Allowed");
        }
    }
}