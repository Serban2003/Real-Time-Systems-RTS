import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        new ExecutionThread(countDownLatch, semaphore1, semaphore2, 7, 2, 3).start();
        new ExecutionThread1(countDownLatch, semaphore1, 3, 3, 5).start();
        new ExecutionThread1(countDownLatch, semaphore2, 2, 4, 6).start();
    }
}