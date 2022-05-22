package concurrency._1_contention;

public class MyRunnableX implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 1_000_000; i++) {
            ContentionExample.incrementX();
        }
    }
}
