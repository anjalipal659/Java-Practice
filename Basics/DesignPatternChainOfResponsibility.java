abstract class SupportHandler {

    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String issue);
}

// Level 1 Support
class BasicSupport extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if (issue.equalsIgnoreCase("password")) {
            System.out.println(
                    "Basic Support handled the password issue."
            );
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        }
    }
}

// Level 2 Support
class TechnicalSupport extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if (issue.equalsIgnoreCase("technical")) {
            System.out.println(
                    "Technical Support handled the technical issue."
            );
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue);
        }
    }
}

// Level 3 Support
class ManagerSupport extends SupportHandler {

    @Override
    public void handleRequest(String issue) {

        if (issue.equalsIgnoreCase("manager")) {
            System.out.println(
                    "Manager handled the issue."
            );
        } else {
            System.out.println(
                    "No handler found for this issue."
            );
        }
    }
}

public class DesignPatternChainOfResponsibility {

    public static void main(String[] args) {

        SupportHandler basic = new BasicSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler manager = new ManagerSupport();

        // Create chain
        basic.setNextHandler(technical);
        technical.setNextHandler(manager);

        System.out.println("Issue 1:");
        basic.handleRequest("password");

        System.out.println("\nIssue 2:");
        basic.handleRequest("technical");

        System.out.println("\nIssue 3:");
        basic.handleRequest("manager");

        System.out.println("\nIssue 4:");
        basic.handleRequest("unknown");
    }
}