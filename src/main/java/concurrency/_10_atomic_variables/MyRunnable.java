package concurrency._10_atomic_variables;

public class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 1; i <= 1_000_000; i++) {
            AtomicVariablesExample.v.incrementAndGet();
        }
    }
}
