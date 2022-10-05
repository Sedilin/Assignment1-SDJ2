package external;

import external.heater.Heater;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model{

    private PropertyChangeSupport support;

    private int previous, current;
    private Heater heater;
    private Thermometer thermometer1;
    private Thermometer thermometer2;
    public ModelManager()
    {
        this.heater = new Heater();
        support = new PropertyChangeSupport(this);
    }

    public Heater getHeater() {
        return heater;
    }

    @Override
    public int getPower() {
        return heater.getPower();
    }

    @Override
    public void heatUp() {
        previous = heater.getPower();
        heater.turnUp();
        current = heater.getPower();

        support.firePropertyChange("PowerChange", previous, current);
    }

    @Override
    public void coolDown() {
        previous = heater.getPower();
        heater.turnDown();
        current = heater.getPower();

        support.firePropertyChange("PowerChange", previous, current);
    }

    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        if (propertyName == null) // all events
        {
            support.addPropertyChangeListener(listener);
        }
        else // a specific event
        {
            support.addPropertyChangeListener(propertyName, listener);
        }
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
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
