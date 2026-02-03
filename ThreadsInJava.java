//Method 1 -> by extending Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i=i+2) {
            System.out.println(i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i=i+2) {
            System.out.println(i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Method 2 -> by implementing Runnable class
class MyThreadRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }
    }
}

public class ThreadsInJava {
    // Main Thread
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread2.start();



        // MyThreadRunnable myThread2 = new MyThreadRunnable();
        // Thread t = new Thread(myThread2);  //passing obj to Thread constructor
        // t.setName("My Thread 1");
        // t.getName();
        // t.start();
        // long id = t.threadId();
        // System.out.println("ID -> " + id);
        // System.out.println(t.isDaemon());
    }
}
