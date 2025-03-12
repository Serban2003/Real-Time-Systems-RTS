public class ThreadR extends Thread{
    Resource res;

    ThreadR(Resource res){
        this.res = res;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Am citit: " + res.read());
        }
    }
}
