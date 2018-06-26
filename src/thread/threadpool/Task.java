package thread.threadpool;

public abstract class Task {
    public enum State {NEW, RUNNING, FINISH};
    private State state = State.NEW;
    public abstract void deal();

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}
