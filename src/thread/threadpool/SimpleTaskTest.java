package thread.threadpool;

public class SimpleTaskTest extends Task{
    @Override
    public void deal() {
        System.out.println("do something");
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolService service = new ThreadPoolService();
        service.start();
        for (int i = 0; i < 10; i++) {
            service.runTask(new SimpleTaskTest());
        }
        Thread.sleep(1000);
        service.stop();
    }
}
