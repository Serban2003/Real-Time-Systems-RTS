import java.util.concurrent.Semaphore;

class Fir extends Thread {
    int intarziere, k, permise, returnat;
    Semaphore s;

    Fir(Semaphore sa, int intarziere, int k, int permise, int returnat) {
        this.s = sa;
        this.intarziere = intarziere;
        this.k = k;
        this.permise = permise;
        this.returnat = returnat;
    }

    public void run() {
        //while (true) {
            try {
                System.out.println(this.getName() + " - STATE 1");
                Thread.sleep(this.intarziere * 500);
                System.out.println(this.getName() + " - STATE 2");

                this.s.tryAcquire(this.permise);
                System.out.println(this.s.availablePermits());
                System.out.println(this.getName() + " a luat " + this.permise + " din semafor");

                System.out.println(this.getName() + " - STATE 3");
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                this.s.release(this.returnat);
                System.out.println(this.s.availablePermits());
                System.out.println(this.getName() + " a eliberat " + this.returnat + " un jeton din semafor");
                System.out.println(this.getName() + " - STATE 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       // }
    }
}
