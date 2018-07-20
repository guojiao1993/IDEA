package thread.pcdemo;

/**
 * 线程通信之测试类
 * @author https://www.cnblogs.com/Wenxu/p/7979023.html
 */

public class PCTest {
    public static void main(String[] args) {
//        singlePC();
        multiPC();
    }
    public static void singlePC() {
        //new一个面包类
        Breads bre = new Breads();

        //new一个生产者类
        Producer proth = new Producer(bre);
        //new一个消费者类
        Consumer conth = new Consumer(bre);

        //new一个包含消费者类的线程
        Thread t1 = new Thread(proth, "生产者");

        //new一个包含生产者类的线程
        Thread t2 = new Thread(conth, "消费者");

        //启动线程
        t1.start();
        t2.start();
    }

    public static void multiPC() {
        //new一个面包类
        Breads bre = new Breads();

        //new一个生产者类
        Producer proth = new Producer(bre);
        //new一个消费者类
        Consumer conth = new Consumer(bre);

        //new一个包含消费者类的线程
        Thread t1 = new Thread(proth, "生产者1");
        Thread t2 = new Thread(proth, "生产者2");
        Thread t3 = new Thread(proth, "生产者3");

        //new一个包含生产者类的线程
        Thread t4 = new Thread(conth, "消费者4");
        Thread t5 = new Thread(conth, "消费者5");
        Thread t6 = new Thread(conth, "消费者6");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
