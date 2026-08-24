// 1. Creating thread by extending Thread
class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThread: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}


// 2. Creating thread using Runnable
class MyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Thread: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}


public class MultithreadingPractice {

    public static void main(String[] args) {

        // Thread using Thread class
        MyThread thread1 = new MyThread();

        // Thread using Runnable
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);

        // Start both threads
        thread1.start();
        thread2.start();

        System.out.println("Main thread is running");
    }
}