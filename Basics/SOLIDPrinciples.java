class Report {

    public void generateReport() {
        System.out.println("Generating Report...");
    }
}

class ReportPrinter {

    public void printReport() {
        System.out.println("Printing Report...");
    }
}

class ReportSaver {

    public void saveReport() {
        System.out.println("Saving Report...");
    }
}

public class SOLIDPrinciples {

    public static void main(String[] args) {

        Report report = new Report();

        report.generateReport();

        ReportPrinter printer = new ReportPrinter();
        printer.printReport();

        ReportSaver saver = new ReportSaver();
        saver.saveReport();
    }
}