import java.util.ArrayList;
import java.util.List;

class PlacementEvent {

    private String eventType;

    public PlacementEvent(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}

class PlacementEventStore {

    private List<PlacementEvent> events =
            new ArrayList<>();

    public void saveEvent(PlacementEvent event) {
        events.add(event);

        System.out.println(
                "Event saved: " + event.getEventType()
        );
    }

    public List<PlacementEvent> getEvents() {
        return events;
    }
}

class PlacementApplication {

    private String status = "Not Applied";

    public void applyEvent(PlacementEvent event) {

        switch (event.getEventType()) {

            case "APPLIED":
                status = "Applied";
                break;

            case "INTERVIEW_SCHEDULED":
                status = "Interview Scheduled";
                break;

            case "INTERVIEW_COMPLETED":
                status = "Interview Completed";
                break;

            case "OFFER_RECEIVED":
                status = "Offer Received";
                break;

            default:
                System.out.println(
                        "Unknown event."
                );
        }
    }

    public String getStatus() {
        return status;
    }
}

public class DesignPatternEventSourcing {

    public static void main(String[] args) {

        PlacementEventStore eventStore =
                new PlacementEventStore();

        eventStore.saveEvent(
                new PlacementEvent("APPLIED")
        );

        eventStore.saveEvent(
                new PlacementEvent("INTERVIEW_SCHEDULED")
        );

        eventStore.saveEvent(
                new PlacementEvent("INTERVIEW_COMPLETED")
        );

        System.out.println();

        PlacementApplication application =
                new PlacementApplication();

        System.out.println("Rebuilding application state...");

        for (PlacementEvent event :
                eventStore.getEvents()) {

            application.applyEvent(event);
        }

        System.out.println(
                "Current Status: "
                        + application.getStatus()
        );
    }
}