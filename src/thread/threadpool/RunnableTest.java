package thread.threadpool;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("已执行 RunnableTest.run()");
    }
}
