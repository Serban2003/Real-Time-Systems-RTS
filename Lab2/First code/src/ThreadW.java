public class ThreadW extends Thread{
    Resource res;
    ThreadW(Resource res){
        this.res = res;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            res.write(i);
            System.out.println("Am scris: " + i);
        }
    }
}
