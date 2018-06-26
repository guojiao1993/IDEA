package thread.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<?> fr = es.submit(new RunnableTest());
        Future<Object> fc = es.submit(new CallableTest());
        System.out.println((String)fc.get());
        if(fr.isDone()) {
            System.out.println("执行完毕 RunnableTest.run()");
        } else {
            System.out.println("未执行完 RunnableTest.run()");
        }
        if (fc.isDone()) {
            System.out.println("执行完毕 CallableTest.call()");
        } else {
            System.out.println("未执行完 CallableTest.call()");
        }
        es.shutdown();
    }
}
