import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        Fir f1, f2;
        f1 = new Fir(s, 2, (int) Math.round(Math.random() * 3 + 2), 2, 1);
        f2 = new Fir(s, 4, (int) Math.round(Math.random() * 3 + 3), 1, 2);
        f1.start();
        f2.start();
    }

}