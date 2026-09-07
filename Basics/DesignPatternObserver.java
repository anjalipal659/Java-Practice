import java.util.ArrayList;
import java.util.List;

interface Observer {

    void update(String message);
}

// Observer 1
class EmailSubscriber implements Observer {

    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(
                name + " received Email: " + message
        );
    }
}

// Observer 2
class SMSSubscriber implements Observer {

    private String name;

    public SMSSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(
                name + " received SMS: " + message
        );
    }
}

// Subject
class YouTubeChannel {

    private List<Observer> subscribers =
            new ArrayList<>();

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void uploadVideo(String videoName) {

        System.out.println(
                "\nNew Video Uploaded: " + videoName
        );

        notifySubscribers(videoName);
    }

    private void notifySubscribers(String videoName) {

        for (Observer observer : subscribers) {
            observer.update(
                    "New video: " + videoName
            );
        }
    }
}

public class DesignPatternObserver {

    public static void main(String[] args) {

        YouTubeChannel channel =
                new YouTubeChannel();

        Observer user1 =
                new EmailSubscriber("Anjali");

        Observer user2 =
                new SMSSubscriber("Rahul");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Java Design Patterns");
    }
}