package thread;

public class InterruptTest {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("在 sleep() 前被执行");
                    Thread.sleep(1000 * 3);
                    System.out.println("在 sleep() 后被执行");
                }catch (InterruptedException e) {
                    System.out.println("在 catch() 中被执行");
                }
                System.out.println("在 try() 后被执行");
            }
        };
        t.start();
        t.interrupt();
    }
}
