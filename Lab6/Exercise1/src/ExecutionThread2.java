import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ExecutionThread2 extends Thread{
    CyclicBarrier barrier;
    Semaphore semaphore1, semaphore2;
    int sleep, activity_min, activity_max;

    public ExecutionThread2(CyclicBarrier barrier, Semaphore semaphore1, Semaphore semaphore2, int sleep, int activity_min, int activity_max) {
        this.barrier = barrier;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        while(true){
            System.out.println(this.getName() + " - STATE 1");

            try {
                semaphore1.acquire(1);
                try {
                    semaphore2.acquire(1);
                    System.out.println(this.getName() + " - STATE 2");
                    int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }

                    try {
                        sleep(sleep * 500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    semaphore2.release(1);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphore1.release(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 3");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
