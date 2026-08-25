class Counter {

    private int count = 0;

    // Synchronized method
    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

class CounterThread extends Thread {

    private Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 1000; i++) {
            counter.increment();
        }
    }
}

public class SynchronizationPractice {

    public static void main(String[] args) {

        Counter counter = new Counter();

        CounterThread thread1 = new CounterThread(counter);
        CounterThread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}