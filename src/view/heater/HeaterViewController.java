package view.heater;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewController implements PropertyChangeListener {

    public Button btnHeatUp;
    public Button btnCoolDown;
    public Label powerValue;
    public Button btnNext;
    private ViewHandler viewHandler;
    private HeaterViewModel model;
    private Region root;

    public void init(ViewHandler viewHandler, HeaterViewModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
    }

    public void reset()
    {
        powerValue.setText("0");
    }

    public Region getRoot()
    {
        return root;
    }


    public void onButtonPressed(ActionEvent e) {

        if (e.getSource() == btnNext)
        {
            viewHandler.openView("thermometer");
        }
        else if(e.getSource() == btnHeatUp)
        {
            model.heatUp();
            reset();
        }
        else if(e.getSource() == btnCoolDown)
        {
            model.coolDown();
            reset();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> powerValue.setText(evt.getNewValue().toString()));
    }
}
