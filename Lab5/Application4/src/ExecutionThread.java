import java.util.concurrent.Semaphore;

public class ExecutionThread extends Thread{
    Semaphore sem;
    int activity_min, activity_max;
    int sleep;

    public ExecutionThread(Semaphore sem, int sleep, int activity_min, int activity_max){
        this.sem = sem;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    @Override
    public void run() {
        //while(true){
            System.out.println(this.getName() + " - STATE 1");

                sem.tryAcquire(1);

                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);

                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                sem.release(1);
                System.out.println(this.getName() + " - STATE 3");
        try {
            sleep(sleep * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 4");
        //}

    }
}
