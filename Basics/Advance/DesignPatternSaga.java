import java.util.ArrayList;
import java.util.List;

class SagaStep {

    private String stepName;
    private Runnable action;
    private Runnable compensation;

    public SagaStep(String stepName, Runnable action, Runnable compensation) {
        this.stepName = stepName;
        this.action = action;
        this.compensation = compensation;
    }

    public void execute() {
        System.out.println("Executing: " + stepName);
        action.run();
    }

    public void compensate() {
        System.out.println("Compensating: " + stepName);
        compensation.run();
    }
}

class PlacementSaga {

    private List<SagaStep> completedSteps = new ArrayList<>();

    public void executeSaga(List<SagaStep> steps) {

        try {
            for (SagaStep step : steps) {
                step.execute();
                completedSteps.add(step);
            }

            System.out.println("\nSaga completed successfully.");

        } catch (Exception e) {

            System.out.println("\nSaga failed: " + e.getMessage());
            System.out.println("Starting compensation...\n");

            for (int i = completedSteps.size() - 1; i >= 0; i--) {
                completedSteps.get(i).compensate();
            }
        }
    }
}

public class DesignPatternSaga {

    public static void main(String[] args) {

        List<SagaStep> steps = new ArrayList<>();

        steps.add(new SagaStep(
                "Apply for Company",
                () -> System.out.println("Application submitted."),
                () -> System.out.println("Application cancelled.")
        ));

        steps.add(new SagaStep(
                "Schedule Interview",
                () -> System.out.println("Interview scheduled."),
                () -> System.out.println("Interview cancelled.")
        ));

        steps.add(new SagaStep(
                "Confirm Interview",
                () -> System.out.println("Interview confirmed."),
                () -> System.out.println("Interview confirmation removed.")
        ));

        steps.add(new SagaStep(
                "Send Notification",
                () -> {
                    System.out.println("Sending notification...");
                    throw new RuntimeException("Notification service failed!");
                },
                () -> System.out.println("Notification action cancelled.")
        ));

        PlacementSaga saga = new PlacementSaga();
        saga.executeSaga(steps);
    }
}