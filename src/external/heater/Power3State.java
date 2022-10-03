package external.heater;

public class Power3State implements HeaterState{
    private static final int power = 3;
    Thread heaterThread;

    public Power3State(Heater heater){
        heaterThread = new Thread(new HeaterThread(heater));
        heaterThread.start();
    }
    @Override
    public void turnUp(Heater heater) {}

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new Power2State());
        heaterThread.interrupt();
    }

    @Override
    public int getPower() {
        return power;
    }
}
