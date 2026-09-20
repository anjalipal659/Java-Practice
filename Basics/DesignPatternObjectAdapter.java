interface USBDevice {

    void connectUSB();
}

class LegacyPrinter {

    public void connectPrinterCable() {
        System.out.println(
                "Legacy printer connected using printer cable."
        );
    }

    public void printDocument() {
        System.out.println("Printing document...");
    }
}

class PrinterObjectAdapter implements USBDevice {

    private LegacyPrinter printer;

    public PrinterObjectAdapter(LegacyPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void connectUSB() {
        System.out.println("USB adapter connected.");
        printer.connectPrinterCable();
    }

    public void print() {
        printer.printDocument();
    }
}

public class DesignPatternObjectAdapter {

    public static void main(String[] args) {

        LegacyPrinter oldPrinter =
                new LegacyPrinter();

        USBDevice adapter =
                new PrinterObjectAdapter(oldPrinter);

        adapter.connectUSB();

        PrinterObjectAdapter printerAdapter =
                (PrinterObjectAdapter) adapter;

        printerAdapter.print();
    }
}