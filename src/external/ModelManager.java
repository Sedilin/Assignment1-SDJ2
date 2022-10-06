package external;

import external.heater.Heater;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model{

    private PropertyChangeSupport support;

    private double currentTemp;
    private int currentPower;
    private Heater heater;
    private Thermometer thermometer1;
    private Thermometer thermometer2;
    public ModelManager()
    {
        this.heater = new Heater();
        this.thermometer1 = new Thermometer("t1", 20, 1, heater);
        this.thermometer2 = new Thermometer("t2", 15, 7, heater);

        Thread t1 = new Thread(thermometer1);
        Thread t2 = new Thread(thermometer2);

        t1.start();
        t2.start();

        support = new PropertyChangeSupport(this);
    }
    @Override
    public Heater getHeater() {
        return heater;
    }
    @Override
    public int getPower() {
        return heater.getPower();
    }

    @Override
    public void heatUp() {
        heater.turnUp();
        currentPower = heater.getPower();

        support.firePropertyChange("Power", null, currentPower);
    }

    @Override
    public void coolDown() {
        heater.turnDown();
        currentPower = heater.getPower();

        support.firePropertyChange("Power", null, currentPower);
    }

    @Override
    public void updateT1()
    {
        currentTemp = thermometer1.getT();
        support.firePropertyChange("T1Change", null, currentTemp);
    }
    @Override
    public void updateT2()
    {
        currentTemp = thermometer2.getT();
        support.firePropertyChange("T2Change", null, currentTemp);
    }

    @Override
    public double returnTemp1()
    {
        return thermometer1.getT();
    }
    @Override
    public double returnTemp2()
    {
        return thermometer2.getT();
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
