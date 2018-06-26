package thread.threadpool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolService {
    public static final int THREAD_COUNT = 5;
    public enum Status {NEW, RUNNING, TERMINATED};
    private Status status = Status.NEW;
    private TaskQueue queue = new TaskQueue();
    private List<Thread> threads = new ArrayList<Thread>();
    public ThreadPoolService() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread t = new TaskThread(this);
            threads.add(t);
        }
    }
    public void start() {
        this.status = Status.RUNNING;
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads.get(i).start();
        }
    }
    public void stop() {
        this.status = Status.TERMINATED;
    }
    public boolean isRunning() {
        return status == Status.RUNNING;
    }
    public void runTask(Task task) {
        queue.addTask(task);
    }
    protected TaskQueue getTaskQueue() {
        return queue;
    }
}
