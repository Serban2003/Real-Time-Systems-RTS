import java.util.concurrent.locks.Lock;

public class ExecutionThread_1Lock extends Thread{
    Lock lock;
    int sleep, activity_min, activity_max;

    public ExecutionThread_1Lock(Lock lock, int sleep, int activity_min, int activity_max){
        this.lock = lock;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        lock.lock();

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
        lock.unlock();
        System.out.println(this.getName() + " - STATE 3");
    }
}
