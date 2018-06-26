package thread.threadpool;

import java.util.concurrent.Callable;

public class CallableTest implements Callable {
    @Override
    public Object call() {
        System.out.println("已执行 CallableTest.call()");
        return "已返回 CallableTest.call()";
    }
}
