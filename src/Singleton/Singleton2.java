package Singleton;

/**
 * 惰性初始化
 *
 * @author Alan
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
