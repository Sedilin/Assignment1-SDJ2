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
            Thread.sleep(10000);
            heater.turnDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
