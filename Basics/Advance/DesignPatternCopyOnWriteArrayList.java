
import java.util.concurrent.CopyOnWriteArrayList;

class PlacementCompanyRegistry {

    private final CopyOnWriteArrayList<String> companies =
            new CopyOnWriteArrayList<>();

    public void addCompany(String company) {
        companies.add(company);
    }

    public void removeCompany(String company) {
        companies.remove(company);
    }

    public void displayCompanies(String readerName) {

        System.out.println(
                readerName + " reading companies:");

        for (String company : companies) {

            System.out.println(company);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public CopyOnWriteArrayList<String> getCompanies() {
        return companies;
    }
}

public class DesignPatternCopyOnWriteArrayList {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementCompanyRegistry registry =
                new PlacementCompanyRegistry();

        registry.addCompany("TCS");
        registry.addCompany("Infosys");
        registry.addCompany("Wipro");

        Thread reader = new Thread(() -> {
            registry.displayCompanies("Reader");
        });

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            registry.addCompany("Accenture");

            System.out.println(
                    "\nWriter added Accenture.");
        });

        reader.start();
        writer.start();

        reader.join();
        writer.join();

        System.out.println(
                "\nFinal Company List: "
                + registry.getCompanies());
    }
}