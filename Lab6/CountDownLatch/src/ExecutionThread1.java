import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ExecutionThread1 extends Thread{
    CountDownLatch countDownLatch;
    Semaphore semaphore;
    int sleep, activity_min, activity_max;

    public ExecutionThread1(CountDownLatch countDownLatch, Semaphore semaphore, int sleep, int activity_min, int activity_max) {
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        try {
            semaphore.acquire();

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

            System.out.println(this.getName() + " - STATE 3");
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
