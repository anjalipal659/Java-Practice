
import java.util.concurrent.Exchanger;

class PlacementDataExchangeTask implements Runnable {

    private final Exchanger<String> exchanger;
    private final String threadName;
    private final String data;

    public PlacementDataExchangeTask(
            Exchanger<String> exchanger,
            String threadName,
            String data) {

        this.exchanger = exchanger;
        this.threadName = threadName;
        this.data = data;
    }

    @Override
    public void run() {

        try {
            System.out.println(
                    threadName + " has: " + data);

            String receivedData =
                    exchanger.exchange(data);

            System.out.println(
                    threadName
                    + " received: "
                    + receivedData);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    threadName + " was interrupted.");
        }
    }
}

public class DesignPatternExchanger {

    public static void main(String[] args)
            throws InterruptedException {

        Exchanger<String> exchanger =
                new Exchanger<>();

        Thread studentThread = new Thread(
                new PlacementDataExchangeTask(
                        exchanger,
                        "Student Thread",
                        "Student Profile"));

        Thread feedbackThread = new Thread(
                new PlacementDataExchangeTask(
                        exchanger,
                        "Feedback Thread",
                        "Interview Feedback"));

        studentThread.start();
        feedbackThread.start();

        studentThread.join();
        feedbackThread.join();

        System.out.println(
                "\nData exchange completed.");
    }
}