package external.heater;

public interface HeaterState {
    void turnUp(Heater heater);

    void turnDown(Heater heater);

    int getPower();
}
