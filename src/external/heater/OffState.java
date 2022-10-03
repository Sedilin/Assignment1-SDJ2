package external.heater;

public class OffState implements HeaterState{
    private static final int power = 0;
    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Heater heater) {}

    @Override
    public int getPower() {
        return power;
    }
}
