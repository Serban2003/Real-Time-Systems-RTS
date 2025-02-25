public class Counter extends Thread{
    int pas;
    int sum;
    public Counter(int pas){
        this.pas = pas;
    }

    @Override
    public void run() {
        sum = 0;
        for(int i =  0; i <= 40; i += pas)
            sum += i;
         System.out.println(Thread.currentThread().getName() + " - Sum=" + sum);
    }

    public int getSum(){
        return sum;
    }
}
