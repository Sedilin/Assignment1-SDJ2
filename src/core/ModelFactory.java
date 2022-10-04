package core;

import external.heater.Heater;
import model.TemperatureListModel;
import model.TemperatureListModelManager;

public class ModelFactory {
    private TemperatureListModel temperatureList;
    private Heater heater;
    public ModelFactory()
    {
        this.temperatureList = new TemperatureListModelManager();
        this.heater = new Heater();
    }

    public Heater getHeater() {
        return heater;
    }

    public TemperatureListModel getTemperatureList() {
        return temperatureList;
    }
}
