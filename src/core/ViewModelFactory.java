package core;

import view.heater.HeaterViewModel;
import view.thermometer.ThermometerViewModel;

public class ViewModelFactory {
    ModelFactory modelFactory;

    ThermometerViewModel thermometerViewModel;
    HeaterViewModel heaterViewModel;

    public ViewModelFactory(ModelFactory modelFactory, ThermometerViewModel thermometerViewModel, HeaterViewModel heaterViewModel)
    {
        this.modelFactory = modelFactory;
        this.heaterViewModel = heaterViewModel;
        this.thermometerViewModel = thermometerViewModel;
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
