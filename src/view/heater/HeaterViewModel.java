package view.heater;

import external.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class HeaterViewModel implements PropertyChangeListener {
    private Model model;
    private StringProperty power;

    public HeaterViewModel(Model model) {
        this.model = model;
        power = new SimpleStringProperty(String.valueOf(model.getPower()));

        model.addListener("Power", this);
    }

    public void heatUp() {
        model.heatUp();
    }

    public void coolDown() {
        model.coolDown();
    }


    public StringProperty getPower() {
        return power;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> power.setValue(evt.getNewValue().toString()));
    }
}
