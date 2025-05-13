import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Controller extends Thread{
    Pcmd pcmd;
    Ptask ptask;
    Pplant pplant;
    Pfeedback pfeedback;
    Pwait pwait;
    PpozPlant ppozPlant;

    public Controller(Ptask ptask, Pcmd pcmd, PpozPlant ppozPlant, Pfeedback pfeedback){
        this.ptask = ptask;
        this.pcmd = pcmd;
        this.pfeedback = pfeedback;
        this.ppozPlant = ppozPlant;
        this.pplant = new Pplant();
        this.pwait = new Pwait();
    }

    @Override
    public void run() {
        while (true) {
            ptask.waitForToken();
            if(pplant.x > ptask.task){
                pcmd.setCmd(-1);
                ptask.setTask(ptask.task);
            }

            else if(pplant.x < ptask.task){
                pcmd.setCmd(1);
                ptask.setTask(ptask.task);
            }
            else pcmd.setCmd(0);

            System.out.println("Controller: T1 executed.");
            pwait.toString();

            ppozPlant.waitForToken();
            pplant.x = ppozPlant.x;
            pfeedback.setX(ppozPlant.x);

            System.out.println("Controller: T2 executed.");
            if(pfeedback.x == ptask.task) pfeedback.s.release();
        }
    }
}
