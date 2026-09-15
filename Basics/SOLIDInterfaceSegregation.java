interface ISPPrintable {
    void print();
}

interface ISPScannable {
    void scan();
}

interface ISPFaxable {
    void fax();
}

class ISPMultiFunctionPrinter
        implements ISPPrintable, ISPScannable, ISPFaxable {

    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax() {
        System.out.println("Sending fax...");
    }
}

class ISPSimplePrinter implements ISPPrintable {

    @Override
    public void print() {
        System.out.println("Simple printer is printing...");
    }
}

public class SOLIDInterfaceSegregation {

    public static void main(String[] args) {

        ISPSimplePrinter simplePrinter = new ISPSimplePrinter();
        simplePrinter.print();

        ISPMultiFunctionPrinter multiPrinter =
                new ISPMultiFunctionPrinter();

        multiPrinter.print();
        multiPrinter.scan();
        multiPrinter.fax();
    }
}