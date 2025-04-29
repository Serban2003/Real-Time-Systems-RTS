import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatchMain = new CountDownLatch(3);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new ExecutionThread(countDownLatchMain, countDownLatch, 7, 2, 3).start();
        new ExecutionThread1(countDownLatchMain, countDownLatch, 3, 3, 5).start();
        new ExecutionThread1(countDownLatchMain, countDownLatch, 2, 4, 6).start();
    }
}