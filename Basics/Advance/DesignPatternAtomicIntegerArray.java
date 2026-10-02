
import java.util.concurrent.atomic.AtomicIntegerArray;

public class DesignPatternAtomicIntegerArray {

    public static void main(String[] args)
            throws InterruptedException {

        // Index 0: TCS
        // Index 1: Infosys
        // Index 2: Wipro

        AtomicIntegerArray applications =
                new AtomicIntegerArray(3);

        Thread tcsThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                applications.incrementAndGet(0);
            }
        });

        Thread infosysThread = new Thread(() -> {
            for (int i = 0; i < 1500; i++) {
                applications.incrementAndGet(1);
            }
        });

        Thread wiproThread = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                applications.incrementAndGet(2);
            }
        });

        tcsThread.start();
        infosysThread.start();
        wiproThread.start();

        tcsThread.join();
        infosysThread.join();
        wiproThread.join();

        System.out.println(
                "TCS Applications: "
                + applications.get(0));

        System.out.println(
                "Infosys Applications: "
                + applications.get(1));

        System.out.println(
                "Wipro Applications: "
                + applications.get(2));

        // Update an element conditionally
        boolean updated =
                applications.compareAndSet(
                        0, 1000, 1200);

        System.out.println(
                "\nTCS Update Successful: " + updated);

        System.out.println(
                "Updated TCS Count: "
                + applications.get(0));
    }
}