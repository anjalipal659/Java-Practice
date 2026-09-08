abstract class DataProcessor {

    // Template Method
    public final void process() {

        readData();
        processData();
        saveData();
    }

    abstract void readData();

    abstract void processData();

    abstract void saveData();
}

// CSV Processor
class CSVProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading CSV data");
    }

    @Override
    void processData() {
        System.out.println("Processing CSV data");
    }

    @Override
    void saveData() {
        System.out.println("Saving CSV data");
    }
}

// Excel Processor
class ExcelProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading Excel data");
    }

    @Override
    void processData() {
        System.out.println("Processing Excel data");
    }

    @Override
    void saveData() {
        System.out.println("Saving Excel data");
    }
}

public class DesignPatternTemplateMethod {

    public static void main(String[] args) {

        DataProcessor csv =
                new CSVProcessor();

        System.out.println("CSV Processing:");
        csv.process();

        System.out.println("\nExcel Processing:");

        DataProcessor excel =
                new ExcelProcessor();

        excel.process();
    }
}
