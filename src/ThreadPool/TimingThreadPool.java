package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.logging.*;

/**
 * TimingThreadPool
 * <p/>
 * Thread pool extended with logging and timing
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TimingThreadPool extends ThreadPoolExecutor {

    public TimingThreadPool() {
        super(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }

    private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println(String.format("Thread %s : start %s", t, r));
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            System.out.println(String.format("Thread %s : end %s, time = %d ns", t, r, taskTime));
            System.out.println();
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            System.out.println(String.format("Terminated : avg time = %d ns",
                    totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = new TimingThreadPool();
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("World");
            }
        });
        es.shutdown();
    }
}
