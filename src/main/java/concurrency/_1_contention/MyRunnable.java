package concurrency._1_contention;

public class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 1_000_000_0; i++) {
            ContentionExample.incrementVSync();
        }
    }
}
