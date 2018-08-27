package ExceptionTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExceptionTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("x正常开始");
                int i = 1 / 0;
                System.out.println("x正常结束");
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("z正常开始");
                System.out.println("z正常结束");
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("b正常开始");
                int i = 1 / 0;
                System.out.println("b正常结束");
            }
        });
        es.shutdown();
    }
}
