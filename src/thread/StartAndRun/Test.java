package thread.StartAndRun;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
//        test.test2();
    }

    /**
     * 异步调用
     * thread.start()
     * run()和main()会交替执行
     */
    public void test1() {
        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(i + " main = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步执行
     * thread.run()
     * 在所有run()执行完毕后main()才会执行
     */
    public void test2() {
        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.run();
        for (int i = 0; i < 10; i++) {
            try {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println(i + " main = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
