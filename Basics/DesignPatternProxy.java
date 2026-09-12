interface Image {

    void display();
}

// Real Object
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println(
                "Loading " + fileName + " from disk..."
        );
    }

    @Override
    public void display() {
        System.out.println(
                "Displaying " + fileName
        );
    }
}

// Proxy
class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}

public class DesignPatternProxy {

    public static void main(String[] args) {

        Image image =
                new ProxyImage("java.jpg");

        System.out.println("First call:");
        image.display();

        System.out.println("\nSecond call:");
        image.display();
    }
}