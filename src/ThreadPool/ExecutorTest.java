package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "\t\t" + Thread.activeCount());
                }
            };
            exec.execute(runnable);
        }
    }
}
