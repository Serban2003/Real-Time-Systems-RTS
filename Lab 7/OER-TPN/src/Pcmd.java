import java.util.concurrent.Semaphore;

public class Pcmd {
    Semaphore s = new Semaphore(0);
    int cmd; // poate avea valori -1, 0, 1
    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException e) { }
    }
    public void setCmd(int cmd) {
        this.cmd = cmd;
        s.release(); // !!!
    }

}
