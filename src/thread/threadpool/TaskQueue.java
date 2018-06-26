package thread.threadpool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskQueue {
    private List<Task> queue = new LinkedList<Task>();
    public synchronized void addTask(Task task) {
        if(task != null) {
            queue.add(task);
        }
    }
    public synchronized void finishTask(Task task) {
        if(task != null) {
            task.setState(Task.State.FINISH);
            queue.remove(task);
        }
    }
    public synchronized Task getTask() {
        Iterator<Task> it = queue.iterator();
        while (it.hasNext()) {
            Task task = it.next();
            if(Task.State.NEW.equals(task.getState())) {
                task.setState(Task.State.RUNNING);
                return task;
            }
        }
        return null;
    }
}
