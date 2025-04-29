import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExecutionThread extends Thread {
    List<Integer> list = new ArrayList<>();
    int sleepTime;
    Exchanger<List<Integer>> exchanger;
    String name;

    ExecutionThread(int sleepTime, Exchanger<List<Integer>> exchanger, String name) {
        this.sleepTime = sleepTime;
        this.exchanger = exchanger;
        this.name = name;
    }

    public void printList() {
        System.out.println(name +  " - " + Arrays.toString(list.toArray()));
    }

    public void run() {
        int numberOfElements = (int) Math.round(Math.random() * 3 + 1);

        for (int i = 0; i < numberOfElements; i++) {
            Integer element = (int) Math.round(Math.random() * 100);
            list.add(element);
        }
        this.printList();

        try {
            Thread.sleep(this.sleepTime);
            this.list = exchanger.exchange(this.list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.printList();
    }
}
