
public class DesignPatternThreadBuilder {

    public static void main(String[] args) throws InterruptedException {

        Thread.Builder builder = Thread.ofVirtual()
                .name("Placement-Task-", 1);

        Thread thread1 = builder.start(() -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " is preparing Java"
            );
        });

        Thread thread2 = builder.start(() -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " is practicing DSA"
            );
        });

        Thread thread3 = builder.start(() -> {
            System.out.println(
                    Thread.currentThread().getName()
                            + " is revising aptitude"
            );
        });

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("All placement tasks completed.");
    }
}
