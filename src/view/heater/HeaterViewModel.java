package view.heater;

import external.Model;
import external.heater.Heater;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import util.PropertyChangeSubject;


public class HeaterViewModel {
    private Model model;
    private IntegerProperty power;

    public HeaterViewModel(Model model) {
        this.model = model;
        power = new SimpleIntegerProperty(model.getPower());
    }

    public void heatUp() {
        model.heatUp();
    }

    public void coolDown() {
        model.coolDown();
    }


    public IntegerProperty getPower() {
        power.setValue(model.getPower());
        return power;
    }

}
