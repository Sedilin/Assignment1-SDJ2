package external.heater;

public class HeaterThread implements Runnable{
    private final Heater heater;
    public HeaterThread(Heater heater)
    {
        this.heater = heater;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(40000);
            heater.turnDown();
        } catch (InterruptedException e) {
            System.out.println("Turn down");
        }
    }
}
