package core;

import view.heater.HeaterViewModel;
import view.thermometer.ThermometerViewModel;

public class ViewModelFactory {
    ModelFactory modelFactory;

    ThermometerViewModel thermometerViewModel;
    HeaterViewModel heaterViewModel;

    public ViewModelFactory(ModelFactory modelFactory)
    {
        this.modelFactory = modelFactory;
        this.heaterViewModel = new HeaterViewModel(modelFactory.getModel());
        this.thermometerViewModel = new ThermometerViewModel(modelFactory.getModel());
    }

    public HeaterViewModel getHeaterViewModel()
    {
        return heaterViewModel;
    }

    public ThermometerViewModel getThermometerViewModel()
    {
        return thermometerViewModel;
    }
}
