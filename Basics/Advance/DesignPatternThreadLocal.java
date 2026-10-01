class PlacementThreadContext {

    private static final ThreadLocal<String> interviewId =
            new ThreadLocal<>();

    public static void setInterviewId(String id) {
        interviewId.set(id);
    }

    public static String getInterviewId() {
        return interviewId.get();
    }

    public static void clear() {
        interviewId.remove();
    }
}

class PlacementInterviewTask implements Runnable {

    private final String id;

    public PlacementInterviewTask(String id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            PlacementThreadContext.setInterviewId(id);

            System.out.println(
                    Thread.currentThread().getName()
                    + " → Interview ID: "
                    + PlacementThreadContext.getInterviewId());

        } finally {
            // Avoid retaining values when threads are reused
            PlacementThreadContext.clear();
        }
    }
}

public class DesignPatternThreadLocal {

    public static void main(String[] args)
            throws InterruptedException {

        Thread t1 = new Thread(
                new PlacementInterviewTask("INT-101"),
                "Interviewer-1");

        Thread t2 = new Thread(
                new PlacementInterviewTask("INT-202"),
                "Interviewer-2");

        Thread t3 = new Thread(
                new PlacementInterviewTask("INT-303"),
                "Interviewer-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nAll interviews completed.");
    }
}