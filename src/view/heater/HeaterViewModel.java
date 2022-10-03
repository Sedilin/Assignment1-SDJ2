package view.heater;

import external.heater.Heater;
import javafx.beans.property.StringProperty;

public class HeaterViewModel {
    private Heater heater;
    private StringProperty power;

    public HeaterViewModel(Heater heater)
    {
        this.heater = heater;
        power.setValue("0");
    }

    public void heatUp()
    {
        heater.turnUp();
    }
    public void coolDown()
    {
        heater.turnDown();
    }
    public void updatePower()
    {
        power.setValue(String.valueOf(heater.getPower()));
    }
    public StringProperty getPower()
    {
        return power;
    }

}
