public class Main {
    public static void main(String[] args) {
        Resource res = new Resource();
        ThreadR threadR = new ThreadR(res);
        ThreadW threadW = new ThreadW(res);

        threadW.start();
        threadR.start();
    }
}