package external;

import external.heater.Heater;
import external.thermometer.Temperature;
import model.TemperatureListModel;
import util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject {

    int getPower();
    void heatUp();
    void coolDown();
    Heater getHeater();

}
