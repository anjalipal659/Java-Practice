class PlacementTokenBucket {

    private final int capacity;
    private final int refillRate;

    private double tokens;
    private long lastRefillTime;

    public PlacementTokenBucket(
            int capacity,
            int refillRate) {

        this.capacity = capacity;
        this.refillRate = refillRate;

        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    private void refill() {

        long currentTime = System.currentTimeMillis();

        long elapsedTime =
                currentTime - lastRefillTime;

        double tokensToAdd =
                (elapsedTime / 1000.0) * refillRate;

        tokens = Math.min(
                capacity,
                tokens + tokensToAdd
        );

        lastRefillTime = currentTime;
    }

    public synchronized boolean allowRequest() {

        refill();

        if (tokens >= 1) {

            tokens--;

            return true;
        }

        return false;
    }

    public synchronized double getAvailableTokens() {

        refill();

        return tokens;
    }
}


public class DesignPatternTokenBucket {

    public static void main(String[] args)
            throws InterruptedException {

        // Capacity = 5 tokens
        // Refill = 1 token per second
        PlacementTokenBucket bucket =
                new PlacementTokenBucket(5, 1);

        System.out.println("Sending requests...\n");

        for (int i = 1; i <= 7; i++) {

            if (bucket.allowRequest()) {

                System.out.println(
                        "Request " + i
                        + " → Allowed");

            } else {

                System.out.println(
                        "Request " + i
                        + " → Rejected");
            }

            Thread.sleep(100);
        }

        System.out.println(
                "\nWaiting for tokens to refill...");

        Thread.sleep(2000);

        System.out.println(
                "Available tokens: "
                + bucket.getAvailableTokens());

        if (bucket.allowRequest()) {

            System.out.println(
                    "New request → Allowed");

        } else {

            System.out.println(
                    "New request → Rejected");
        }
    }
}