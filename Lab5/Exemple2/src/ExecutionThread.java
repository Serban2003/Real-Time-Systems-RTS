import java.util.concurrent.locks.Lock;

public class ExecutionThread extends Thread{
    Lock lock1, lock2;
    int sleep, activity_min1, activity_max1, activity_min2, activity_max2;

    public ExecutionThread(Lock lock1, Lock lock2, int sleep, int activity_min1, int activity_max1, int activity_min2, int activity_max2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.sleep = sleep;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        int k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        lock1.lock();
        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);

        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        if(lock2.tryLock()){
            System.out.println(this.getName() + " - STATE 3");

            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
        else{
            lock1.unlock();
            try {
                sleep(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock1.lock();
            lock2.lock();
            System.out.println(this.getName() + " - STATE 3");

            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

        System.out.println(this.getName() + " - STATE 4");
    }
}
