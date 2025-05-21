public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pcmd pcmd = new Pcmd();
        Ptask ptask = new Ptask();
        Pfeedback pfeedback = new Pfeedback();
        PpozPlant ppozplant = new PpozPlant();
        PlantRobot p = new PlantRobot(pcmd, ppozplant);
        Controller c = new Controller(ptask, pcmd, ppozplant, pfeedback);

        p.start();
        c.start();

        int[] tasks = {4, 2, 4, 3};
        int k = 0;
        while(k < tasks.length){
            System.out.println("\nExecuting new task: " + tasks[k]);
            ptask.setTask(tasks[k]);
            pfeedback.waitForToken();
            k++;
        }

    }
}