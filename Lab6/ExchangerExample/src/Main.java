import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();

        new ExecutionThread(1000, exchanger, "Duke").start();
        new ExecutionThread(5000, exchanger, "Wild Wings").start();
    }
}