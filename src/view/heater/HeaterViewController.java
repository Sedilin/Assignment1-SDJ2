package view.heater;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewController {

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

        powerValue.textProperty().bind(model.getPower());
    }

    public void reset()
    {

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
        }
        else if(e.getSource() == btnCoolDown)
        {
            model.coolDown();
        }
    }


}
