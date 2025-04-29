import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("Rutina barierei");
            }
        });

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        new ExecutionThread1(barrier, semaphore1, 4, 2, 4).start();
        new ExecutionThread2(barrier, semaphore1, semaphore2, 3, 3, 6).start();
        new ExecutionThread1(barrier, semaphore2, 5, 2, 5).start();
    }
}