package external.heater;

public class Heater {
    private HeaterState currentState = new OffState();

    public void turnUp(){
        currentState.turnUp(this);
    }
    public void turnDown()
    {
        currentState.turnDown(this);
    }
    public int getPower()
    {
        return currentState.getPower();
    }
    void setPowerState(HeaterState state)
    {
        currentState = state;
    }

}
