import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread{
    CountDownLatch countDownLatchMain;
    CountDownLatch countDownLatch;
    int sleep, activity_min, activity_max;

    public ExecutionThread(CountDownLatch countDownLatchMain, CountDownLatch countDownLatch, int sleep, int activity_min, int activity_max) {
        this.countDownLatchMain = countDownLatchMain;
        this.countDownLatch = countDownLatch;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        try {
            sleep(sleep * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        countDownLatch.countDown();

        System.out.println(this.getName() + " - STATE 3");
        countDownLatchMain.countDown();
        try {
            countDownLatchMain.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
