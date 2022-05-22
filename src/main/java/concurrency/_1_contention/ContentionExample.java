package concurrency._1_contention;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentionExample {

  public static long v = 0;
  public static long x = 0;
  public static final Object lockV = new Object();
  public static final Object lockX = new Object();

  public static void main(String[] args) throws InterruptedException {

    long startTime = new Date().getTime();

    long threadsNr = 15;
    List<Thread> list = new ArrayList<>();
    for(int i=0;i<threadsNr;i++) {
      list.add(new Thread(new MyRunnable()));
    }
//    for(int i=0;i<threadsNr;i++) {
//      list.add(new Thread(new MyRunnableX()));
//    }

    //start all
    for (Thread thread : list) {
      thread.start();
    }

    //wait for all
    for(Thread thread: list) {
      thread.join();
    }

    System.out.println(v); //why is v not 5000000000 ?
    System.out.println(x); //why is v not 5000000000 ?
    System.out.println(1_000_000L * threadsNr);

    long endTime = new Date().getTime();
    System.out.println(endTime-startTime);
  }

  public static void incrementV() {
    // some instructions that take long to run and are not problematic for sync
    //
    //
    //
    synchronized (lockV) {
      v++;
    }
  }

  public static void incrementX() {
    // some instructions that take long to run and are not problematic for sync
    //
    //
    //
    synchronized (lockX) {
      x++;
    }
  }

  public static synchronized void incrementVSync() {
    v++;
    //
    //
    //
    incrementXSync();
  }

  public static synchronized void incrementXSync() {
    x++;
  }

}
