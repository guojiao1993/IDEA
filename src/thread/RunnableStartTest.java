package thread;

public class RunnableStartTest {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableTest());
        t.start();
    }
}
