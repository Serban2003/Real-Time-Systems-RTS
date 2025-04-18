import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        new ExecutionThread(l1, l2, 4, 2, 4,4, 6).start();
        new ExecutionThread(l2, l1, 5, 3, 5, 5, 7).start();
    }
}