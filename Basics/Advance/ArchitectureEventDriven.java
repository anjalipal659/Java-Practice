import java.util.ArrayList;
import java.util.List;

// EVENT
class PlacementEventMessage {

    private String eventType;
    private String company;

    public PlacementEventMessage(String eventType, String company) {
        this.eventType = eventType;
        this.company = company;
    }

    public String getEventType() {
        return eventType;
    }

    public String getCompany() {
        return company;
    }
}

// LISTENER
interface PlacementEventListener {

    void onEvent(PlacementEventMessage event);
}

// EMAIL LISTENER
class PlacementEmailListener implements PlacementEventListener {

    @Override
    public void onEvent(PlacementEventMessage event) {

        System.out.println(
                "Email sent: Application submitted for "
                + event.getCompany());
    }
}

// DASHBOARD LISTENER
class PlacementDashboardListener implements PlacementEventListener {

    @Override
    public void onEvent(PlacementEventMessage event) {

        System.out.println(
                "Dashboard updated for "
                + event.getCompany());
    }
}

// EVENT PUBLISHER
class PlacementEventPublisher {

    private List<PlacementEventListener> listeners =
            new ArrayList<>();

    public void subscribe(PlacementEventListener listener) {
        listeners.add(listener);
    }

    public void publish(PlacementEventMessage event) {

        System.out.println(
                "\nEvent published: "
                + event.getEventType());

        for (PlacementEventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

// MAIN
public class ArchitectureEventDriven {

    public static void main(String[] args) {

        PlacementEventPublisher publisher =
                new PlacementEventPublisher();

        publisher.subscribe(new PlacementEmailListener());
        publisher.subscribe(new PlacementDashboardListener());

        PlacementEventMessage event =
                new PlacementEventMessage(
                        "APPLICATION_APPLIED",
                        "TCS");

        publisher.publish(event);
    }
}