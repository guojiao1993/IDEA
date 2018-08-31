package Singleton;

/**
 * 惰性初始化holder类技巧
 *
 * @author Alan
 */
public class Singleton3 {
    private Singleton3() {
    }

    public synchronized static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }
}
