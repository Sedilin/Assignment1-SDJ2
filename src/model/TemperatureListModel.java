package model;

import external.thermometer.Temperature;
import util.PropertyChangeSubject;

public interface TemperatureListModel extends PropertyChangeSubject {
    void addTemperature(String id, double value);
    Temperature getTemperature(String id);
}
