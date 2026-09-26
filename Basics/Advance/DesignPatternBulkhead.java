import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BulkheadCompanyService {

    private ExecutorService companyPool =
            Executors.newFixedThreadPool(2);

    public void processCompanyRequest(int requestNumber) {

        companyPool.submit(() -> {

            System.out.println(
                    "Company request "
                    + requestNumber
                    + " started."
            );

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(
                    "Company request "
                    + requestNumber
                    + " completed."
            );
        });
    }

    public void shutdown() {
        companyPool.shutdown();
    }
}


class BulkheadStudyService {

    private ExecutorService studyPool =
            Executors.newFixedThreadPool(2);

    public void processStudyRequest(int requestNumber) {

        studyPool.submit(() -> {

            System.out.println(
                    "Study request "
                    + requestNumber
                    + " started."
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(
                    "Study request "
                    + requestNumber
                    + " completed."
            );
        });
    }

    public void shutdown() {
        studyPool.shutdown();
    }
}


public class DesignPatternBulkhead {

    public static void main(String[] args)
            throws InterruptedException {

        BulkheadCompanyService companyService =
                new BulkheadCompanyService();

        BulkheadStudyService studyService =
                new BulkheadStudyService();

        companyService.processCompanyRequest(1);
        companyService.processCompanyRequest(2);
        companyService.processCompanyRequest(3);
        companyService.processCompanyRequest(4);

        studyService.processStudyRequest(1);
        studyService.processStudyRequest(2);
        studyService.processStudyRequest(3);

        Thread.sleep(5000);

        companyService.shutdown();
        studyService.shutdown();

        System.out.println("\nAll services finished.");
    }
}