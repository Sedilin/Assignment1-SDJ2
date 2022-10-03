package external.heater;

public class Power2State implements HeaterState{
    private static final int power = 2;

    @Override
    public void turnUp(Heater heater) {
        heater.setPowerState(new Power3State(heater));
    }

    @Override
    public void turnDown(Heater heater) {
        heater.setPowerState(new Power1State());
    }

    @Override
    public int getPower() {
        return power;
    }
}
