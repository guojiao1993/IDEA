package thread.DuoXianChengHeXinJiShu;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(1000);
                System.out.println(i + " run = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
