
public class AdvancedThreadLocalExample {

    private static final ThreadLocal<String> userContext =
            ThreadLocal.withInitial(() -> "Guest");

    public static void main(String[] args) {

        Thread user1 = new Thread(() -> {
            userContext.set("Anjali");

            System.out.println(
                    Thread.currentThread().getName()
                            + ": " + userContext.get()
            );

            userContext.remove();
        }, "Thread-1");

        Thread user2 = new Thread(() -> {
            userContext.set("Rahul");

            System.out.println(
                    Thread.currentThread().getName()
                            + ": " + userContext.get()
            );

            userContext.remove();
        }, "Thread-2");

        user1.start();
        user2.start();
    }
}
