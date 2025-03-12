public class Resource {
    int buf;

    synchronized void write(int a) {
        buf = a;
        try {
            notify();
            wait(150);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
    }
    synchronized int read() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notify();
        return buf;
    }
}
