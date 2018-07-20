package thread.pcdemo;

/**
 * 线程通信之面包类
 * @author https://www.cnblogs.com/Wenxu/p/7979023.html
 */
public class Breads {

    //面包的id
    private int bid;
    //面包的个数
    private int num;

    //有参构造
    public Breads(int bid, int num) {
        this.bid = bid;
        this.num = num;
    }

    //无参构造
    public Breads() {
    }

    //生产面包的方法（由于是demo，方便大家理解，就把synchronized关键字加到方法上面了哦）
    public synchronized void produc() {
        //当面包的数量不为0时，该方法处于等待状态
        while (0 != num) {
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当面包数量为0时，那么就开始生产面包了哦
        num = num + 1;//数量加1
        bid = bid + 1;//id当然也得加1
        String threadname = Thread.currentThread().getName();
        System.out.println(threadname + "生产了一个编号为" + bid + "的面包！");
        notifyAll();//当执行完后，去唤醒其他处于等待的线程
    }

    //消费面包的方法
    public synchronized void consume() {
        //当面包的数量为0时，该方法处于等待状态
        while (num == 0) {
            try {
                wait();//等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //消费完面包了，所以面包数量降为0了
        num = num - 1;//数量减1
        String name1 = Thread.currentThread().getName();
        System.out.println(name1 + "购买了一个编号为" + bid + "的面板！");
        notifyAll();//当执行完后，去唤醒其他处于等待的线程
    }

    //set和get方法
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
