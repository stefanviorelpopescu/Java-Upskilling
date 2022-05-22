package concurrency._1_contention;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockHowTo {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    //Locking using Lock and ReentrantLock
    public int getCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
            return count++;
        } finally {
            lock.unlock();
        }
    }

    //Implicit locking using synchronized keyword
    public synchronized int getCountTwo() {
        System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
        return count++;
    }



    public static void main(String args[]) {
        final ReentrantLockHowTo counter = new ReentrantLockHowTo();
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (counter.getCountTwo() < 6) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (counter.getCountTwo() < 6) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }
}