package core;

import external.heater.Heater;
import model.TemperatureListModel;

public class ModelFactory {
    private TemperatureListModel temperatureList;
    private Heater heater;
    public ModelFactory(TemperatureListModel temperatureList, Heater heater)
    {
        this.temperatureList = temperatureList;
        this.heater = heater;
    }

    public Heater getHeater() {
        return heater;
    }

    public TemperatureListModel getTemperatureList() {
        return temperatureList;
    }
}
