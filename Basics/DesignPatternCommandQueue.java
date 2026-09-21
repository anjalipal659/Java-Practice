import java.util.LinkedList;
import java.util.Queue;

interface QueueCommand {
    void execute();
}

class PlacementEmailCommand implements QueueCommand {

    private String candidateName;

    public PlacementEmailCommand(String candidateName) {
        this.candidateName = candidateName;
    }

    @Override
    public void execute() {
        System.out.println(
                "Email sent to " + candidateName
                        + " about placement update."
        );
    }
}

class InterviewReminderCommand implements QueueCommand {

    private String candidateName;

    public InterviewReminderCommand(String candidateName) {
        this.candidateName = candidateName;
    }

    @Override
    public void execute() {
        System.out.println(
                "Interview reminder sent to "
                        + candidateName + "."
        );
    }
}

class CommandQueueProcessor {

    private Queue<QueueCommand> commandQueue =
            new LinkedList<>();

    public void addCommand(QueueCommand command) {
        commandQueue.add(command);

        System.out.println("Command added to queue.");
    }

    public void processCommands() {

        System.out.println();
        System.out.println("Processing commands...");

        while (!commandQueue.isEmpty()) {

            QueueCommand command =
                    commandQueue.poll();

            command.execute();
        }
    }
}

public class DesignPatternCommandQueue {

    public static void main(String[] args) {

        CommandQueueProcessor processor =
                new CommandQueueProcessor();

        processor.addCommand(
                new PlacementEmailCommand("Anjali")
        );

        processor.addCommand(
                new InterviewReminderCommand("Anjali")
        );

        processor.addCommand(
                new PlacementEmailCommand("Rahul")
        );

        processor.processCommands();
    }
}