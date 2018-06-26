package thread.threadpool;

public class TaskThread extends Thread{
    private ThreadPoolService service;
    public TaskThread(ThreadPoolService service) {
        this.service = service;
    }
    public void run() {
        while (service.isRunning()) {
            TaskQueue queue = service.getTaskQueue();
            Task task = queue.getTask();
            if(task != null) {
                task.deal();
            }
            queue.finishTask(task);
        }
    }
}
