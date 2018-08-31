package Singleton;

enum SingletonEnum {
    INSTANCE;
    Object object;

    SingletonEnum() {
        object = new Object();
    }

    public Object getInstance() {
        return object;
    }
}

/**
 * 枚举实现单例模式
 *
 * @author Alan
 */
public class Singleton5 {
    public static void main(String[] args) {
        Object instance = SingletonEnum.INSTANCE.getInstance();
    }
}
