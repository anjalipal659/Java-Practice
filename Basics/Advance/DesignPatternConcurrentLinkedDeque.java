import java.util.concurrent.ConcurrentLinkedDeque;

class PlacementTaskDeque {

    private final ConcurrentLinkedDeque<String> deque =
            new ConcurrentLinkedDeque<>();

    public void addAtFront(String task) {
        deque.addFirst(task);
    }

    public void addAtBack(String task) {
        deque.addLast(task);
    }

    public String processFromFront() {
        return deque.pollFirst();
    }

    public String processFromBack() {
        return deque.pollLast();
    }

    public String viewFront() {
        return deque.peekFirst();
    }

    public String viewBack() {
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}

public class DesignPatternConcurrentLinkedDeque {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementTaskDeque taskDeque =
                new PlacementTaskDeque();

        Thread frontProducer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                String task =
                        "Urgent Task-" + i;

                taskDeque.addAtFront(task);

                System.out.println(
                        "Added at Front → " + task);
            }
        });

        Thread backProducer = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                String task =
                        "Normal Task-" + i;

                taskDeque.addAtBack(task);

                System.out.println(
                        "Added at Back → " + task);
            }
        });

        frontProducer.start();
        backProducer.start();

        frontProducer.join();
        backProducer.join();

        System.out.println(
                "\nFront Element → "
                + taskDeque.viewFront());

        System.out.println(
                "Back Element → "
                + taskDeque.viewBack());

        System.out.println("\nProcessing Tasks:");

        while (!taskDeque.isEmpty()) {

            String task;

            if (Math.random() > 0.5) {
                task = taskDeque.processFromFront();
            } else {
                task = taskDeque.processFromBack();
            }

            if (task != null) {
                System.out.println(
                        "Processed → " + task);
            }
        }

        System.out.println(
                "\nDeque Empty: "
                + taskDeque.isEmpty());
    }
}