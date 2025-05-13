import java.io.Serial;
import java.util.concurrent.Semaphore;

public class Pfeedback {
    int x;
    Semaphore s = new Semaphore(0);
    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException e) { }
    }
    public void setX(int x) {
        this.x = x;
        System.out.println("Feedback: " + this.x);
    }
}
