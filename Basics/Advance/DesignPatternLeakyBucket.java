import java.util.LinkedList;
import java.util.Queue;

class PlacementLeakyBucket {

    private final int capacity;
    private final int leakRate;

    private final Queue<String> requestQueue;

    public PlacementLeakyBucket(int capacity, int leakRate) {

        this.capacity = capacity;
        this.leakRate = leakRate;

        requestQueue = new LinkedList<>();
    }

    public synchronized boolean addRequest(String request) {

        if (requestQueue.size() >= capacity) {

            return false;
        }

        requestQueue.add(request);

        return true;
    }

    public synchronized void processRequests() {

        int processed = 0;

        while (!requestQueue.isEmpty()
                && processed < leakRate) {

            String request = requestQueue.poll();

            System.out.println(
                    "Processing → " + request);

            processed++;
        }
    }

    public synchronized int getQueueSize() {

        return requestQueue.size();
    }
}

public class DesignPatternLeakyBucket {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementLeakyBucket bucket =
                new PlacementLeakyBucket(5, 2);

        System.out.println("Adding requests...\n");

        for (int i = 1; i <= 7; i++) {

            boolean added =
                    bucket.addRequest("Request-" + i);

            if (added) {

                System.out.println(
                        "Request-" + i
                        + " → Added");

            } else {

                System.out.println(
                        "Request-" + i
                        + " → Rejected (Bucket Full)");
            }
        }

        System.out.println(
                "\nQueue Size: "
                + bucket.getQueueSize());

        System.out.println(
                "\nProcessing requests...\n");

        bucket.processRequests();

        System.out.println(
                "\nRemaining Requests: "
                + bucket.getQueueSize());

        Thread.sleep(1000);

        System.out.println(
                "\nProcessing again...\n");

        bucket.processRequests();

        System.out.println(
                "\nRemaining Requests: "
                + bucket.getQueueSize());
    }
}