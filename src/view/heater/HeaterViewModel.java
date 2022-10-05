package view.heater;

import external.Model;
import external.heater.Heater;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.PropertyChangeSubject;


public class HeaterViewModel {
    private Model model;
    private StringProperty power;

    public HeaterViewModel(Model model) {
        this.model = model;
        power = new SimpleStringProperty("0");
    }

    public void heatUp() {
        model.heatUp();
    }

    public void coolDown() {
        model.coolDown();
    }

    public void updatePower() {
        power.setValue(String.valueOf(model.getPower()));
    }

    public StringProperty getPower() {
        return power;
    }

}
