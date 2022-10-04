package view.heater;

import core.ViewHandler;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class HeaterViewController {

    public Button btnHeatUp;
    public Button btnCoolDown;
    public Label labelValue;
    public Button btnNext;
    public Button btnReset;
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
        labelValue.setText("0");
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
