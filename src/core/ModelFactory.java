package core;

import external.Model;
import external.ModelManager;
import external.heater.Heater;
import model.TemperatureListModel;
import model.TemperatureListModelManager;

public class ModelFactory {
    Model model;
    public ModelFactory()
    {
        model = new ModelManager();
    }

    public Model getModel() {
        return model;
    }
}
