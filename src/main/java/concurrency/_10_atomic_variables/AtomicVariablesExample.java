package concurrency._10_atomic_variables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicVariablesExample
{
    public static AtomicLong v = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {

        long threadsNr = 15;
        List<Thread> list = new ArrayList<>();
        for(int i=0;i<threadsNr;i++) {
            list.add(new Thread(new MyRunnable()));
        }

        //start all
        for (Thread thread : list) {
            thread.start();
        }

        //wait for all
        for(Thread thread: list) {
            thread.join();
        }

        System.out.println(v); //why is v not 5000000000 ?
        System.out.println(1_000_000L * threadsNr);

    }
}
