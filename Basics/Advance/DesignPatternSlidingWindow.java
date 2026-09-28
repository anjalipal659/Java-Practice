import java.util.ArrayDeque;
import java.util.Deque;

class PlacementSlidingWindow {

    private final int maxRequests;
    private final long windowSizeMillis;

    private final Deque<Long> requestTimes;

    public PlacementSlidingWindow(
            int maxRequests,
            int windowSizeSeconds) {

        this.maxRequests = maxRequests;
        this.windowSizeMillis =
                windowSizeSeconds * 1000L;

        requestTimes = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {

        long currentTime =
                System.currentTimeMillis();

        // Remove requests outside the window
        while (!requestTimes.isEmpty()
                && currentTime - requestTimes.peekFirst()
                >= windowSizeMillis) {

            requestTimes.pollFirst();
        }

        // Check limit
        if (requestTimes.size() >= maxRequests) {

            return false;
        }

        requestTimes.addLast(currentTime);

        return true;
    }

    public synchronized int getRequestCount() {

        long currentTime =
                System.currentTimeMillis();

        while (!requestTimes.isEmpty()
                && currentTime - requestTimes.peekFirst()
                >= windowSizeMillis) {

            requestTimes.pollFirst();
        }

        return requestTimes.size();
    }
}

public class DesignPatternSlidingWindow {

    public static void main(String[] args)
            throws InterruptedException {

        // Maximum 5 requests in 3 seconds
        PlacementSlidingWindow limiter =
                new PlacementSlidingWindow(5, 3);

        System.out.println("Sending requests...\n");

        for (int i = 1; i <= 7; i++) {

            if (limiter.allowRequest()) {

                System.out.println(
                        "Request " + i + " → Allowed");

            } else {

                System.out.println(
                        "Request " + i + " → Rejected");
            }

            Thread.sleep(200);
        }

        System.out.println(
                "\nRequests in current window: "
                + limiter.getRequestCount());

        System.out.println(
                "\nWaiting for window to move...");

        Thread.sleep(3200);

        if (limiter.allowRequest()) {

            System.out.println(
                    "New request → Allowed");

        } else {

            System.out.println(
                    "New request → Rejected");
        }
    }
}