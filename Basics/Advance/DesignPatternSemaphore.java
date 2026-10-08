import java.util.concurrent.Semaphore;

class PlacementLab {

    private final Semaphore availableSystems =
            new Semaphore(2);

    public void useSystem(String student)
            throws InterruptedException {

        System.out.println(
                student + " is waiting for a system.");

        availableSystems.acquire();

        try {

            System.out.println(
                    student + " got a system.");

            Thread.sleep(2000);

            System.out.println(
                    student + " completed practice.");

        } finally {

            availableSystems.release();

            System.out.println(
                    student + " released the system.");
        }
    }
}

public class DesignPatternSemaphore {

    public static void main(String[] args)
            throws InterruptedException {

        PlacementLab lab =
                new PlacementLab();

        Thread[] students = new Thread[5];

        for (int i = 0; i < students.length; i++) {

            String student =
                    "Student-" + (i + 1);

            students[i] = new Thread(() -> {

                try {
                    lab.useSystem(student);

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                }
            });

            students[i].start();
        }

        for (Thread student : students) {
            student.join();
        }

        System.out.println(
                "\nAll students completed practice.");
    }
}