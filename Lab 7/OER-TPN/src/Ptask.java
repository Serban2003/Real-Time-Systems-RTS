import java.util.concurrent.Semaphore;

public class Ptask {
    Semaphore s = new Semaphore(0);
    int task;
    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException e) { }
    }
    public void setTask(int task) {
        this.task = task;
        s.release(); // !!!
    }
}
