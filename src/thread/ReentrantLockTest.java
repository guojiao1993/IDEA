package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private Lock lock = new ReentrantLock();
    public void testLock() {
        lock.lock();
        try {
            System.out.println("in lock");
        } finally {
            lock.unlock();
        }
    }
}
