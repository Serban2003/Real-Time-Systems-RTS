public class Main {
    public static void runThreadsWithThreadClass(){
        Counter c1 = new Counter(3);
        Counter c2 = new Counter(4);
        Counter c3 = new Counter(5);

        c1.start();
        c2.start();
        c3.start();

        try {
            c1.join();
            c2.join();
            c3.join();
            System.out.println(c1.getSum() + c2.getSum() + c3.getSum());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runThreadsWithRunnable(){
        CounterRunnable cr1 = new CounterRunnable(3);
        CounterRunnable cr2 = new CounterRunnable(4);
        CounterRunnable cr3 = new CounterRunnable(5);

        Thread thread1 = new Thread(cr1);
        Thread thread2 = new Thread(cr2);
        Thread thread3 = new Thread(cr3);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Thread1 Priority: " + thread1.getPriority());
        thread1.setPriority(10);
        System.out.println("Thread1 Priority: " + thread1.getPriority());

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println(cr1.getSum() + cr2.getSum() + cr3.getSum());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        //runThreadsWithThreadClass();
        runThreadsWithRunnable();
    }
}