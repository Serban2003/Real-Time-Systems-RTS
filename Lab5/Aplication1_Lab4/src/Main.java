import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        new ExecutionThread_1Lock(lock1,4, 2, 4).start();
        new ExecutionThread_2Lock(lock1, lock2, 3, 3, 6).start();
        new ExecutionThread_1Lock(lock2, 5, 2, 5).start();
    }
}