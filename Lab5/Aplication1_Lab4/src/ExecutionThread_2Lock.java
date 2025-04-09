import java.util.concurrent.locks.Lock;

public class ExecutionThread_2Lock extends Thread{
    Lock lock1, lock2;
    int sleep, activity_min, activity_max;

    public ExecutionThread_2Lock(Lock lock1, Lock lock2, int sleep, int activity_min, int activity_max){
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        lock1.lock();
        lock2.lock();
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        try {
            Thread.sleep(sleep * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.unlock();
        lock2.unlock();
        System.out.println(this.getName() + " - STATE 3");
    }
}
