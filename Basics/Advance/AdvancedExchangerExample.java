
import java.util.concurrent.Exchanger;

public class AdvancedExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread student1 = new Thread(() -> {
            try {
                String data = "Java Notes";
                System.out.println("Student 1 has: " + data);

                String received = exchanger.exchange(data);

                System.out.println("Student 1 received: " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread student2 = new Thread(() -> {
            try {
                String data = "SQL Notes";
                System.out.println("Student 2 has: " + data);

                String received = exchanger.exchange(data);

                System.out.println("Student 2 received: " + received);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        student1.start();
        student2.start();
    }
}
