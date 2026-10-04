
import java.util.concurrent.ConcurrentHashMap;

class PlacementApplicationTracker {

    private final ConcurrentHashMap<String, Integer> applications =
            new ConcurrentHashMap<>();

    public void addApplication(String company) {
        applications.merge(company, 1, Integer::sum);
    }

    public int getApplications(String company) {
        return applications.getOrDefault(company, 0);
    }

    public void displayApplications() {
        applications.forEach((company, count) ->
                System.out.println(
                        company + " → " + count));
    }
}

public class DesignPatternConcurrentHashMap {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementApplicationTracker tracker =
                new PlacementApplicationTracker();

        String[] companies = {
                "TCS", "Infosys", "Wipro",
                "TCS", "Wipro", "TCS"
        };

        Thread[] threads = new Thread[companies.length];

        for (int i = 0; i < companies.length; i++) {

            final String company = companies[i];

            threads[i] = new Thread(() -> {
                tracker.addApplication(company);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Application Counts:\n");
        tracker.displayApplications();

        System.out.println(
                "\nTCS Applications: "
                + tracker.getApplications("TCS"));
    }
}