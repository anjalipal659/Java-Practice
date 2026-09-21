import java.util.ArrayList;
import java.util.List;

interface PlacementEventListener {
    void onEvent(String event);
}

class PlacementEventBus {

    private List<PlacementEventListener> listeners =
            new ArrayList<>();

    public void subscribe(PlacementEventListener listener) {
        listeners.add(listener);
    }

    public void publish(String event) {

        System.out.println("Event Published: " + event);

        for (PlacementEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

class DashboardEventListener
        implements PlacementEventListener {

    @Override
    public void onEvent(String event) {
        System.out.println(
                "Dashboard updated: " + event
        );
    }
}

class NotificationEventListener
        implements PlacementEventListener {

    @Override
    public void onEvent(String event) {
        System.out.println(
                "Notification sent: " + event
        );
    }
}

public class DesignPatternEventBus {

    public static void main(String[] args) {

        PlacementEventBus eventBus =
                new PlacementEventBus();

        DashboardEventListener dashboard =
                new DashboardEventListener();

        NotificationEventListener notification =
                new NotificationEventListener();

        eventBus.subscribe(dashboard);
        eventBus.subscribe(notification);

        eventBus.publish(
                "Candidate applied for TCS."
        );

        System.out.println();

        eventBus.publish(
                "Interview scheduled for Anjali."
        );
    }
}