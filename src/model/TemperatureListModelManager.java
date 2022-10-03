package model;

import external.thermometer.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TemperatureListModelManager implements TemperatureListModel{

    private ArrayList<Temperature> temperatureList;
    private PropertyChangeSupport support;

    @Override
    public void addTemperature(String id, double value) {
        temperatureList.add(new Temperature(id, value));
    }

    @Override
    public Temperature getTemperature(String id) {
        for (Temperature temperature : temperatureList)
        {
            if (temperature.getId().equals(id))
            {
                return temperature;
            }
        }
        return null;
    }

    @Override public void addListener(String propertyName,
                                      PropertyChangeListener listener)
    {
        if (propertyName == null) // all events
        {
            support.addPropertyChangeListener(listener);
        }
        else // a specific event
        {
            support.addPropertyChangeListener(propertyName, listener);
        }
    }

    @Override public void removeListener(String propertyName,
                                         PropertyChangeListener listener)
    {

        if (propertyName == null) // all events
        {
            support.removePropertyChangeListener(listener);
        }
        else // a specific event
        {
            support.removePropertyChangeListener(propertyName, listener);
        }
    }
}
