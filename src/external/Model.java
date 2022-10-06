package external;

import external.heater.Heater;
import util.PropertyChangeSubject;

public interface Model extends PropertyChangeSubject {

    int getPower();
    void heatUp();
    void coolDown();
    Heater getHeater();
    void updateT1();
    void updateT2();
    double returnTemp1();
    double returnTemp2();
}
