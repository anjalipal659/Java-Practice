
public class DesignPatternThreadIsVirtual {

    public static void main(String[] args) throws InterruptedException {

        // Platform thread
        Thread platformThread = Thread.ofPlatform()
                .name("Platform-Thread")
                .unstarted(() -> {
                    System.out.println("Platform thread running");
                });

        // Virtual thread
        Thread virtualThread = Thread.ofVirtual()
                .name("Virtual-Thread")
                .unstarted(() -> {
                    System.out.println("Virtual thread running");
                });

        System.out.println("Platform thread virtual? "
                + platformThread.isVirtual());

        System.out.println("Virtual thread virtual? "
                + virtualThread.isVirtual());

        platformThread.start();
        virtualThread.start();

        platformThread.join();
        virtualThread.join();
    }
}
