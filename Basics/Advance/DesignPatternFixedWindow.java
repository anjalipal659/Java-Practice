class PlacementFixedWindow {

    private final int maxRequests;
    private final long windowSizeMillis;

    private int requestCount;
    private long windowStartTime;

    public PlacementFixedWindow(
            int maxRequests,
            int windowSizeSeconds) {

        this.maxRequests = maxRequests;
        this.windowSizeMillis =
                windowSizeSeconds * 1000L;

        this.requestCount = 0;
        this.windowStartTime =
                System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {

        long currentTime =
                System.currentTimeMillis();

        // Check whether current window has expired
        if (currentTime - windowStartTime
                >= windowSizeMillis) {

            requestCount = 0;
            windowStartTime = currentTime;
        }

        // Check request limit
        if (requestCount >= maxRequests) {

            return false;
        }

        requestCount++;

        return true;
    }

    public synchronized int getRequestCount() {

        return requestCount;
    }
}

public class DesignPatternFixedWindow {

    public static void main(String[] args)
            throws InterruptedException {

        // Maximum 5 requests in 3 seconds
        PlacementFixedWindow limiter =
                new PlacementFixedWindow(5, 3);

        System.out.println(
                "Sending requests...\n");

        for (int i = 1; i <= 7; i++) {

            if (limiter.allowRequest()) {

                System.out.println(
                        "Request " + i
                        + " → Allowed");

            } else {

                System.out.println(
                        "Request " + i
                        + " → Rejected");
            }

            Thread.sleep(200);
        }

        System.out.println(
                "\nRequests in current window: "
                + limiter.getRequestCount());

        System.out.println(
                "\nWaiting for current window to expire...");

        Thread.sleep(3200);

        if (limiter.allowRequest()) {

            System.out.println(
                    "New Window Request → Allowed");

        } else {

            System.out.println(
                    "New Window Request → Rejected");
        }

        System.out.println(
                "Requests in new window: "
                + limiter.getRequestCount());
    }
}